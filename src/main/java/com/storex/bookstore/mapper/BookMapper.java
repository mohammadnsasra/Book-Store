package com.storex.bookstore.mapper;

import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Book;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookMapper {
    public Book toBook(BookRequest request);

    public BookResponse toBookResponse(Book book);

    public MessageResponse toMessageResponse(String msg);


}
