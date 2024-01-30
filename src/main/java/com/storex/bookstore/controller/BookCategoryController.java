package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/BookCategories")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @PostMapping
    public BookCategoryResponse save(@RequestBody BookCategoryRequest request){

        return this.bookCategoryService.save(request);
    }
}
