package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepoDb extends JpaRepository<Category,Long> {

}
