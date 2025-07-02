package org.example.memorydatabase.book.controller;

import lombok.RequiredArgsConstructor;
import org.example.memorydatabase.book.db.entity.BookEntity;
import org.example.memorydatabase.book.db.repository.BookRepository;
import org.example.memorydatabase.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }
    @DeleteMapping("/user/{id}")
    public void delete(
            @PathVariable Long id
    ){
        bookService.delete(id);
    }
    @GetMapping("/user/{id}")
    public Optional<BookEntity> findById(
            @PathVariable Long id
    ){
        return bookService.findById(id);
    }

}
