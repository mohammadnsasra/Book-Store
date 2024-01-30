package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request){

        return this.categoryService.save(request);
    }
}
