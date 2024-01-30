package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.CategoryMapper;
import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Category;
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

    @Override
    public CategoryResponse save(CategoryRequest request) {

        Category category=this.categoryMapper.toCategory(request);

        category.setCreatedAt(LocalDateTime.now());
        return this.categoryMapper.toCategoryResponse(this.categoryRepo.save(category));
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category= this.categoryRepo.getById(id).orElseThrow(()->
                new NotFoundException("this author does not exist"));
        return this.categoryMapper.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> findAll() {
        if(!this.categoryRepo.findAll().isEmpty())
            return this.categoryRepo.findAll().stream().map(c->this.categoryMapper.toCategoryResponse(c)).collect(Collectors.toList());

        throw new NotFoundException("Not Found Any Category");
    }

    @Override
    public MessageResponse deleteById(Long id) {
        this.getById(id);
        this.categoryRepo.deleteById(id);
        return this.categoryMapper.toMessageResponse(String.format("The [%s] Category is deleted successfully",id));
    }
}
