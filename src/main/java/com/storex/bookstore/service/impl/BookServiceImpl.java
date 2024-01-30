package com.storex.bookstore.service.impl;

import com.storex.bookstore.costumeException.NotFoundException;
import com.storex.bookstore.mapper.BookMapper;
import com.storex.bookstore.model.dto.request.BookRequest;
import com.storex.bookstore.model.dto.response.BookResponse;
import com.storex.bookstore.model.dto.response.MessageResponse;
import com.storex.bookstore.model.entity.Book;
import com.storex.bookstore.model.entity.Category;
import com.storex.bookstore.repository.BookRepo;
import com.storex.bookstore.repository.CategoryRepo;
import com.storex.bookstore.service.AuthorService;
import com.storex.bookstore.service.BookService;
import com.storex.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookResponse save(BookRequest request) {

        this.authorService.getById(request.getAuthorId());

        Book book=this.bookMapper.toBook(request);

        return this.bookMapper.toBookResponse(this.bookRepo.save(book));
    }

    @Override
    public BookResponse getById(Long id) {
        Book book= this.bookRepo.getById(id).orElseThrow(()->
                new NotFoundException("this book does not exist"));

        return this.bookMapper.toBookResponse(book);
    }

    @Override
    public List<BookResponse> findAll() {
        if(!this.bookRepo.findAll().isEmpty())
            return this.bookRepo.findAll().stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());

        throw new NotFoundException("Not Found Any book");
    }


    @Override
    public List<BookResponse> findByCreateDate(String createDate) {
        return this.bookRepo.findByCreateDate(createDate).stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> findByAuthorId(Long authorId) {
        if(this.authorService.getById(authorId) ==null){
            throw new NotFoundException("this author does not exist "+authorId);
        }

        List<Book> book=this.bookRepo.findByAuthorId(authorId);

        return book.stream().map(c->this.bookMapper.toBookResponse(c)).collect(Collectors.toList());
    }



    @Override
    public BookResponse update(BookRequest request) {
       Book book=this.bookMapper.toBook(request);

       this.getById(book.getId());
       book.setUpdatedAt(LocalDateTime.now());
     return   this.bookMapper.toBookResponse(this.bookRepo.save(book));
    }

    @Override
    public MessageResponse deleteById(Long id) {
        this.getById(id);

        this.bookRepo.deleteById(id);

        return this.bookMapper.toMessageResponse(String.format("The [%s] book is deleted successfully",id));
    }


    //    @Override
    //    public BookResponse findByCategoryId(Long categoryId) {
    //        return null;
    //    }
}
