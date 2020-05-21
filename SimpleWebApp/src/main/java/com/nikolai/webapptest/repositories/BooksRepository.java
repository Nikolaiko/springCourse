package com.nikolai.webapptest.repositories;

import com.nikolai.webapptest.domain.Book;
import org.springframework.data.repository.CrudRepository;


public interface BooksRepository extends CrudRepository<Book, Long> {
}
