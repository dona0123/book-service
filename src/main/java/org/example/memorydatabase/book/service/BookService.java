package org.example.memorydatabase.book.service;

import org.example.memorydatabase.book.db.entity.BookEntity;
import org.example.memorydatabase.book.db.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService extends BookEntity {

    public final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //create, update
    public BookEntity create(BookEntity book) {
        return bookRepository.save(book);
    }

    //all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    //delete
    public void delete(Long id) {
        this.bookRepository.delete(id);
    }

    //find one
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }
}
