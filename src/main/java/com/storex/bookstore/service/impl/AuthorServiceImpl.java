package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.AuthorMapper;
import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Author;
import com.storex.bookstore.repository.AuthorRepo;
import com.storex.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public AuthorResponse save(AuthorRequest request) {
        Author author=this.authorMapper.toAuthor(request);
        author.setCreatedAt(LocalDateTime.now());
        author.setUpdatedAt(LocalDateTime.now());
        return this.authorMapper.toAuthorResponse(this.authorRepo.save(author));
    }

    @Override
    public AuthorResponse getById(Long id) {
        Author author= this.authorRepo.getById(id).orElseThrow(()->
                new NotFoundException("this author does not exist"));
        return this.authorMapper.toAuthorResponse(author);
    }

    @Override
    public List<AuthorResponse> findAll() {
        if(!this.authorRepo.findAll().isEmpty())
            return this.authorRepo.findAll().stream().map(c->this.authorMapper.toAuthorResponse(c)).collect(Collectors.toList());

        throw new NotFoundException("Not Found Any Author");
    }

    @Override
    public MessageResponse deleteById(Long id) {
        this.getById(id);
        this.authorRepo.deleteById(id);
        return this.authorMapper.toMessageResponse(String.format("The [%s] Author is deleted successfully",id));

    }

}
