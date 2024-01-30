package com.storex.bookstore.repository;

import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo {
   // public List<Category> findById(List<Long> ids);

    public Category save(Category category);

    public Optional<Category> getById(Long id);

    public List<Category> findAll();

    void deleteById(Long id);
}
