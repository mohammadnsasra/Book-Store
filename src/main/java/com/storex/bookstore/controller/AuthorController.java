package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.AuthorRequest;
import com.storex.bookstore.model.dto.response.AuthorResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Author;
import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@Valid @RequestBody AuthorRequest request){
        return ResponseEntity.ok(this.authorService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable Long id){

        return ResponseEntity.ok(this.authorService.getById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AuthorResponse>> getAll(){

        return ResponseEntity.ok(this.authorService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(this.authorService.deleteById(id));
    }
}
