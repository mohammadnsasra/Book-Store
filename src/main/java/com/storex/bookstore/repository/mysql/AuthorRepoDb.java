package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepoDb extends JpaRepository<Author,Long> {
}
