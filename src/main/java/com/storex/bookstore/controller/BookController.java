package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponse save(@Valid @RequestBody BookRequest request){

        return this.bookService.save(request);
    }

    @PutMapping
    public BookResponse update(@Valid @RequestBody BookRequest request) {
        return this.bookService.update(request);
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id){
        return this.bookService.getById(id);
    }
   @GetMapping("/findAll")
    public List<BookResponse> findAll() {
        return this.bookService.findAll();
    }
    @GetMapping("/byAuthorId/{authorId}")
    public List<BookResponse> findByAuthorId(Long authorId) {
        return this.bookService.findByAuthorId(authorId);
    }

   @GetMapping("/byDate/{createDate}")
    public List<BookResponse> findByCreateDate(String createDate) {
        return this.bookService.findByCreateDate(createDate);
    }
   @DeleteMapping("/{id}")
    public MessageResponse deleteById(@RequestParam Long id) {
        return this.bookService.deleteById(id);
    }
}
