package com.storex.bookstore.repository.impl;

import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.repository.BookRepo;
import com.storex.bookstore.repository.mysql.BookRepoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepoImpl implements BookRepo {
    @Autowired
    private BookRepoDb bookRepoDb;

    @Override
    public Book save(Book book) {
        return this.bookRepoDb.save(book);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return this.bookRepoDb.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepoDb.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepoDb.deleteById(id);
    }

    @Override
    public List<Book> findByCreateDate(String createDate) {
        return this.bookRepoDb.findByCreateDate(createDate);
    }

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        return this.bookRepoDb.findByAuthorId(authorId);
    }

//    @Override
//    public Book findByCategoryId(Long categoryId) {
//        return this.bookRepoDb.findByCategoryId(categoryId);
//    }
}
