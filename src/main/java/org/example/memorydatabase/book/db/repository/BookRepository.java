package org.example.memorydatabase.book.db.repository;

import org.example.memorydatabase.book.db.entity.BookEntity;
import org.example.memorydatabase.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity,Long> {


}
