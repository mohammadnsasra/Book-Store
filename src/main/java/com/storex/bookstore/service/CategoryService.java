package com.storex.bookstore.service;

import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;

import java.util.List;

public interface CategoryService {

    public CategoryResponse save(CategoryRequest request);

    public CategoryResponse getById(Long id);

    public List<CategoryResponse> findAll();

    MessageResponse deleteById(Long id);
}
