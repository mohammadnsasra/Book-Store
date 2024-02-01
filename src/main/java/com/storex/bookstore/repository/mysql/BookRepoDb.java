package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.dto.response.BookProjection;
import com.storex.bookstore.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepoDb extends JpaRepository<Book,Long> {
    public List<Book> findByCreateDate(String createDate);

    public List<Book> findByAuthorId(Long authorId);

    List<Book> findByCategories_Id(Long categoryId);

}
