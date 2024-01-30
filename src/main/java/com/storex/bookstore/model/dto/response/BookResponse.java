package com.storex.bookstore.model.dto.response;



import com.storex.bookstore.model.entity.Category;
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

public class BookResponse {
    private long id;

    private Long authorId;

    private String name;

    private String createDate;

    private Double price;

    private String description;

    List<CategoryResponse> categories;

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    private  LocalDateTime updatedAt;
}
