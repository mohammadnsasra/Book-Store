package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryDb extends JpaRepository<BookCategory,Long> {
}
