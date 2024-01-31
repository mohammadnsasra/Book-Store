package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepoDb extends JpaRepository<Category,Long> {
public Optional<Category> findByName(String name);
}
