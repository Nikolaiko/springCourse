package com.nikolai.recepieapp.repositories;

import com.nikolai.recepieapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
