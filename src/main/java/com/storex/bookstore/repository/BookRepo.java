package com.storex.bookstore.repository;

import com.storex.bookstore.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepo {
    public Book save(Book book);

    public Optional<Book> getById(Long id);

    public List<Book> findAll();

    void deleteById(Long id);

    public List<Book> findByCreateDate(String createDate);
    public List<Book> findByAuthorId(Long authorId);

   // public Book findByCategoryId(Long categoryId);
}

