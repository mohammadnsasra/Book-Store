package com.storex.bookstore.mapper;

import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    public Category toCategory(CategoryRequest request);

    public CategoryResponse toCategoryResponse(Category category);

    public MessageResponse toMessageResponse(String msg);
}
