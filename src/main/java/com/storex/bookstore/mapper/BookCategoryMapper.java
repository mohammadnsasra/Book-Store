package com.storex.bookstore.mapper;

import com.storex.bookstore.model.dto.request.BookCategoryRequest;
import com.storex.bookstore.model.dto.response.BookCategoryResponse;
import com.storex.bookstore.model.entity.BookCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookCategoryMapper {

    public BookCategory toBookCategory(BookCategoryRequest request);
    public BookCategoryResponse toBookCategoryResponse(BookCategory bookCategory);
}
