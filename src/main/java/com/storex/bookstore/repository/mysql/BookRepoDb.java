package com.storex.bookstore.repository.mysql;

import com.storex.bookstore.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepoDb extends JpaRepository<Book,Long> {
    public List<Book> findByCreateDate(String createDate);
    public List<Book> findByAuthorId(Long authorId);

  //  public Book findByCategoryId(Long categoryId);
}
