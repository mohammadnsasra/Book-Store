package com.storex.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "category_id")
    private Long categoryId;

    @JsonBackReference
    @JoinColumn(name="book_id",insertable = false,updatable = false)
    @ManyToOne
   private Book book;

    @JsonBackReference
    @JoinColumn(name="category_id",insertable = false,updatable = false)
    @ManyToOne
    private Category category;
}
