package com.storex.bookstore.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookCategoryResponse {

    private String categoryName;

    private Long id;

    private Long bookId;

    private Long categoryId;
}
