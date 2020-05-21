package com.nikolai.webapptest.repositories;

import com.nikolai.webapptest.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
