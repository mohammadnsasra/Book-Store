package com.storex.bookstore.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public interface BookProjection {
     Long getId();
     Long getAuthorId();
     String getName();
     String getCreateDate();
     String getPrice();
     String getDescription();

   // List<BookCategoryResponse> getBookCategories();

     LocalDateTime getCreatedAt();
     LocalDateTime getUpdatedAt();
     LocalDateTime getDeletedAt();

}
