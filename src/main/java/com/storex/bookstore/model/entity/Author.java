package com.storex.bookstore.model.entity;

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
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    List<Book> books;


    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt=LocalDateTime.now();;



    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private  LocalDateTime updatedAt=LocalDateTime.now();;
}
