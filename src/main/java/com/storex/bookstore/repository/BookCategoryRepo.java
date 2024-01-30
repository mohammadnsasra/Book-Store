package com.storex.bookstore.repository;


import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookCategoryRepo {
    public BookCategory save(BookCategory bookCategory);

    public Optional<BookCategory> getById(Long id);

    public List<BookCategory> findAll();

    void deleteById(Long id);
}
