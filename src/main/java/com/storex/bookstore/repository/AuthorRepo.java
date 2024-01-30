package com.storex.bookstore.repository;

import com.storex.bookstore.model.entity.Author;


import java.util.List;
import java.util.Optional;

public interface AuthorRepo {
    public Author save(Author author);

    public Optional<Author> getById(Long id);

    public List<Author> findAll();

    void deleteById(Long id);


}
