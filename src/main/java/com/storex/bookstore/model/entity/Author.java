package com.storex.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.storex.bookstore.model.enums.Status;
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
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Book> books;


    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private  LocalDateTime updatedAt;
}