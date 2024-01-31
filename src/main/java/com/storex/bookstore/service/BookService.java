package com.storex.bookstore.service;

import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.model.dto.response.BookProjection;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public BookResponse save(BookRequest book);
    public BookResponse getById(Long id);

    public List<BookResponse> findAll();

    MessageResponse deleteById(Long id);

    public List<BookResponse> findByCreateDate(String createDate);
    public List<BookResponse> findByAuthorId(Long authorId);

    public List<BookResponse> findByCategoryId(Long categoryId);


    public BookResponse update(BookRequest  request,Long bookId);
}

