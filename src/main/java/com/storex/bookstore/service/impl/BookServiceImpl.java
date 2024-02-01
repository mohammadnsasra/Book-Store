package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.BookMapper;
import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.Category;
import com.storex.bookstore.repository.AuthorRepo;
import com.storex.bookstore.repository.BookRepo;
import com.storex.bookstore.repository.CategoryRepo;
import com.storex.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo  authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookResponse save(BookRequest request) {
        this.authorRepo.getById(request.getAuthorId()).orElseThrow(()->
                new NotFoundException("this Author does not exist " +request.getAuthorId()));

        Book book=this.bookMapper.toBook(request);
        List<Category> categoryList=new ArrayList<>();
        for (Long categoryId : request.getCategoryIds()) {
            Category category = this.categoryRepo.getById(categoryId).orElseThrow(() ->
                    new NotFoundException("this category does not exist"));
           categoryList.add(category);
        }

        book.setCategories(categoryList);
        book.setCreatedAt(LocalDateTime.now());

        return this.bookMapper.toBookResponse(this.bookRepo.save(book));
    }

    @Override
    public BookResponse getById(Long id) {
        Book book= this.bookRepo.getById(id).orElseThrow(()->
                new NotFoundException("this book does not exist"));

        return this.bookMapper.toBookResponse(book);
    }

    @Override
    public List<BookResponse> findAll() {
        if(!this.bookRepo.findAll().isEmpty())
            return this.bookRepo.findAll().stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());

        throw new NotFoundException("Not Found Any book");
    }


    @Override
    public List<BookResponse> findByCreateDate(String createDate) {
        return this.bookRepo.findByCreateDate(createDate).stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findByAuthorId(Long authorId) {
        if(this.authorRepo.getById(authorId).isEmpty()){
            throw new NotFoundException("this author does not exist "+authorId);
        }

        List<Book> book=this.bookRepo.findByAuthorId(authorId);

        return book.stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findByCategoryId(Long categoryId) {
        if(this.categoryRepo.getById(categoryId).isEmpty()){
            throw new NotFoundException("this category does not exist "+ categoryId);
        }
        List<Book> book= this.bookRepo.findByCategoryId(categoryId);
        return   book.stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());
    }


    @Override
    public BookResponse update(BookRequest request,Long bookId) {
        this.authorRepo.getById(request.getAuthorId()).orElseThrow(()->
                new NotFoundException("this Author does not exist " +request.getAuthorId()));

        Book book=this.bookRepo.getById(bookId).orElseThrow(()->
                new NotFoundException("this book does not exist "+bookId));

        List<Category> categoryList=new ArrayList<>();
        for (Long categoryId : request.getCategoryIds()) {
            Category category = this.categoryRepo.getById(categoryId).orElseThrow(() ->
                    new NotFoundException("this category does not exist"));
            categoryList.add(category);
        }
        book.setCategories(categoryList);
        book.setName(request.getName());
        book.setCreateDate(request.getCreateDate());
        book.setDescription(request.getDescription());
        book.setAuthorId(request.getAuthorId());
        book.setPrice(request.getPrice());
        book.setUpdatedAt(LocalDateTime.now());

     return   this.bookMapper.toBookResponse(this.bookRepo.save(book));
    }

    @Override
    public MessageResponse deleteById(Long id) {
        this.getById(id);

        this.bookRepo.deleteById(id);

        return this.bookMapper.toMessageResponse(String.format("The [%s] book is deleted successfully",id));
    }

}
