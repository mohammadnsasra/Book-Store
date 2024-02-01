package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.ConflictException;
import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.CategoryMapper;
import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.Category;
import com.storex.bookstore.repository.BookRepo;
import com.storex.bookstore.repository.CategoryRepo;
import com.storex.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public CategoryResponse save(CategoryRequest request) {
       if(this.categoryRepo.findByName(request.getName()).isPresent()){
           throw new ConflictException("this name of category already exist "+request.getName());
       }
        Category category=this.categoryMapper.toCategory(request);

        category.setCreatedAt(LocalDateTime.now());
        return this.categoryMapper.toCategoryResponse(this.categoryRepo.save(category));
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category= this.categoryRepo.getById(id).orElseThrow(()->
                new NotFoundException("this category does not exist"));
        return this.categoryMapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> findAll() {
        if(!this.categoryRepo.findAll().isEmpty())
            return this.categoryRepo.findAll().stream().map(c->this.categoryMapper.toCategoryResponse(c)).collect(Collectors.toList());

        throw new NotFoundException("Not Found Any Category");
    }

    @Override
    public CategoryResponse findByName(String name) {
        Category category= this.categoryRepo.findByName(name).orElseThrow(()->
                new NotFoundException("this category does not exist"));

        return this.categoryMapper.toCategoryResponse(category);
    }

    @Override
    public MessageResponse deleteById(Long id) {

        Category category=this.categoryRepo.getById(id).orElseThrow(()->
                new NotFoundException("this category does not exist"));

       List<Book> books=this.bookRepo.findByCategoryId(id);
        for(Book book:books) {
            book.getCategories().remove(category);
        }
        this.bookRepo.saveAll(books);
        this.categoryRepo.deleteById(id);

        return new MessageResponse(String.format("The [%s] Category is deleted successfully",id));
    }
}
