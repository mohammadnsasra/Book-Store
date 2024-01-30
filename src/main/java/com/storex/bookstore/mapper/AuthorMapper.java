package com.storex.bookstore.mapper;

import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Author;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    public Author toAuthor(AuthorRequest request);

    public AuthorResponse toAuthorResponse(Author author);

    public MessageResponse toMessageResponse(String msg);
}
