package com.storex.bookstore.model.dto.response;


import com.storex.bookstore.model.entity.Book;
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
public class CategoryResponse {

    private long id;

    private String name;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;
}
