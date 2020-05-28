package com.nikolai.recepieapp.services;

import com.nikolai.recepieapp.domain.Recipe;
import com.nikolai.recepieapp.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void prepare() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe testRecipe = new Recipe();
        Set<Recipe> testData = new HashSet<>();
        testData.add(testRecipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(testData);

        Set<Recipe> actualData = recipeService.getRecipes();
        Assert.assertEquals(actualData.size(), testData.size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}