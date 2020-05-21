package com.nikolai.webapptest.repositories;

import com.nikolai.webapptest.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishersRepository extends CrudRepository<Publisher, Long> {
}
