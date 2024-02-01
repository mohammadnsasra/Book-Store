package com.storex.bookstore.service;


import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import java.util.List;


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

