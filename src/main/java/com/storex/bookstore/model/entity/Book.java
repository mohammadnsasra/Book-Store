package com.storex.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;

   @Column(name = "author_id")
    private Long authorId;

    @Column(name = "book_name")
    private String name;

    private String description;

    private String createDate;

    private Double price;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    List<Category> categories;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id",insertable = false,updatable = false)
    private Author author;


    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt=LocalDateTime.now();


    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private  LocalDateTime updatedAt=LocalDateTime.now();



}
