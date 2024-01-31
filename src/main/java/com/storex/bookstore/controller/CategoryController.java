package com.storex.bookstore.controller;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.request.CategoryRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.CategoryResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Category;
import com.storex.bookstore.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request){

        return ResponseEntity.ok(this.categoryService.save(request));
    }

   @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponse>> findAll() {

        return ResponseEntity.ok(this.categoryService.findAll());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<CategoryResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.categoryService.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) {
       return ResponseEntity.ok(this.categoryService.deleteById(id));
    }
}
