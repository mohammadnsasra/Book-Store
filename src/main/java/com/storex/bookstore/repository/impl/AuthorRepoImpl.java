package com.storex.bookstore.repository.impl;

import com.storex.bookstore.model.entity.Author;
import com.storex.bookstore.repository.AuthorRepo;
import com.storex.bookstore.repository.mysql.AuthorRepoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepoImpl implements AuthorRepo {
    @Autowired
    private AuthorRepoDb authorRepoDb;

    @Override
    public Author save(Author author) {
        return this.authorRepoDb.save(author);
    }

    @Override
    public Optional<Author> getById(Long id) {
        return this.authorRepoDb.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepoDb.findAll();
    }

    @Override
    public void deleteById(Long id) {

        this.authorRepoDb.deleteById(id);
    }
}
