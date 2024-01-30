package com.storex.bookstore.repository.impl;

import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.BookCategory;
import com.storex.bookstore.repository.BookCategoryRepo;
import com.storex.bookstore.repository.mysql.BookCategoryDb;
import com.storex.bookstore.repository.mysql.BookRepoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookCategoryImpl implements BookCategoryRepo {
    @Autowired
    private BookCategoryDb bookCategoryDb;

    @Override
    public BookCategory save(BookCategory book) {
        return this.bookCategoryDb.save(book);
    }

    @Override
    public Optional<BookCategory> getById(Long id) {
        return this.bookCategoryDb.findById(id);
    }

    @Override
    public List<BookCategory> findAll() {
        return this.bookCategoryDb.findAll();
    }

    @Override
    public void deleteById(Long id) {
      this.bookCategoryDb.deleteById(id);
    }
}
