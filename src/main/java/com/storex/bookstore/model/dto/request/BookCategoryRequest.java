package com.storex.bookstore.model.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookCategoryRequest {

    @NotNull(message = "the bookId is required")
    private Long bookId;

    @NotNull(message = "the categoryId is required")
    private Long categoryId;
}
