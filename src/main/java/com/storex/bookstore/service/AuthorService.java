package com.storex.bookstore.service;


import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Author;

import java.util.List;

public interface AuthorService {
    public AuthorResponse save(AuthorRequest request);
    public AuthorResponse getById(Long id);
    public List<AuthorResponse> findAll();

    MessageResponse deleteById(Long id);
}
