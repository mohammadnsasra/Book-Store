package com.storex.bookstore.model.dto.response;



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

public class AuthorResponse {

    private Long authorId;

    private String authorName;

    List<BookResponse> books;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;
}

// get ->
// in book -> get book by auth id
// in auth -> get book by aut id

