package com.storex.bookstore.service;

import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;

import java.util.List;

public interface BookCategoryService {

    public BookCategoryResponse save(BookCategoryRequest request);

    public BookCategoryResponse getById(Long id);

    public List<BookCategoryResponse> findAll();

    MessageResponse deleteById(Long id);

}
