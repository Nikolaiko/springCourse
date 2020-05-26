package com.nikolai.recepieapp.repositories;

import com.nikolai.recepieapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
