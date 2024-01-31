package com.storex.bookstore.controller;

import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> save(@Valid @RequestBody BookRequest request){

        return ResponseEntity.ok(this.bookService.save(request));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponse> update(@Valid @RequestBody BookRequest request,@PathVariable Long bookId) {
        return ResponseEntity.ok(this.bookService.update(request,bookId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id){

        return ResponseEntity.ok(this.bookService.getById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<BookResponse>> findAll() {

        return ResponseEntity.ok(this.bookService.findAll());
    }
    @GetMapping("/byAuthorId/{authorId}")
    public ResponseEntity<List<BookResponse>> findByAuthorId(Long authorId) {
        return ResponseEntity.ok(this.bookService.findByAuthorId(authorId));
    }

   @GetMapping("/byDate/{createDate}")
    public ResponseEntity<List<BookResponse>> findByCreateDate(String createDate) {
        return ResponseEntity.ok(this.bookService.findByCreateDate(createDate));
    }


    @GetMapping("/byCategory/{categoryId}")
    public ResponseEntity<List<BookResponse>> findByCategoryId(Long categoryId) {
        return ResponseEntity.ok(this.bookService.findByCategoryId(categoryId));
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@RequestParam Long id) {

        return ResponseEntity.ok(this.bookService.deleteById(id));
    }
}
