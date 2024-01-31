package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.costumeException.ValidationError;
import com.storex.bookstore.mapper.BookCategoryMapper;
import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.BookCategory;
import com.storex.bookstore.repository.BookCategoryRepo;
import com.storex.bookstore.repository.BookRepo;
import com.storex.bookstore.repository.CategoryRepo;
import com.storex.bookstore.service.BookCategoryService;
import com.storex.bookstore.service.BookService;
import com.storex.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public BookCategoryResponse save(BookCategoryRequest request) {

        if(this.bookRepo.getById(request.getBookId()).isEmpty()) {
            throw new NotFoundException("this book does not exist " + request.getBookId());
        }

        if(this.categoryRepo.getById(request.getCategoryId()).isEmpty()) {
            throw new NotFoundException("this category does not exist " + request.getCategoryId());
        }


        BookCategory bookCategory=this.bookCategoryMapper.toBookCategory(request);

        return this.bookCategoryMapper.toBookCategoryResponse(this.bookCategoryRepo.save(bookCategory));
    }

    @Override
    public BookCategoryResponse getById(Long id) {
        return null;
    }

    @Override
    public List<BookCategoryResponse> findAll() {
        return null;
    }

    @Override
    public MessageResponse deleteById(Long id) {
        return null;
    }
}
