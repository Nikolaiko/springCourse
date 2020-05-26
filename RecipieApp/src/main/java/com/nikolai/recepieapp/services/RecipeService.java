package com.nikolai.recepieapp.services;

import com.nikolai.recepieapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
