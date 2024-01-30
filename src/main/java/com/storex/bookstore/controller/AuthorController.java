package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Author;
import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorResponse save(@RequestBody AuthorRequest request){

        return this.authorService.save(request);
    }

    @GetMapping("/{id}")
    public AuthorResponse getById(@PathVariable Long id){

        return this.authorService.getById(id);
    }

    @GetMapping("/get-all")
    public List<AuthorResponse> getAll(){
        return this.authorService.findAll();
    }
    @DeleteMapping("/{id}")
    public MessageResponse deleteById(@PathVariable Long id){
        return this.authorService.deleteById(id);
    }
}
