package com.storex.bookstore.repository.impl;

import com.storex.bookstore.model.entity.Category;
import com.storex.bookstore.repository.CategoryRepo;
import com.storex.bookstore.repository.mysql.CategoryRepoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
    @Autowired
    private CategoryRepoDb categoryRepoDb;


    @Override
    public Category save(Category category) {
        return this.categoryRepoDb.save(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return this.categoryRepoDb.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepoDb.findAll();
    }

    @Override
    public Optional<Category> findByName(String name) {
        return this.categoryRepoDb.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
     this.categoryRepoDb.deleteById(id);
    }
}
