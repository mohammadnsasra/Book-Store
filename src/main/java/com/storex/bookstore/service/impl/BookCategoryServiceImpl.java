package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.BookCategoryMapper;
import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.BookCategory;
import com.storex.bookstore.repository.BookCategoryRepo;
import com.storex.bookstore.service.BookCategoryService;
import com.storex.bookstore.service.BookService;
import com.storex.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public BookCategoryResponse save(BookCategoryRequest request) {

        if(this.bookService.getById(request.getBookId()) == null) {
            throw new NotFoundException("this book does not exist " + request.getBookId());
        }

        if(this.categoryService.getById(request.getCategoryId()) == null) {
            throw new NotFoundException("this category does not exist " + request.getBookId());
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
