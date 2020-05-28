package com.nikolai.recepieapp.controllers;

import com.nikolai.recepieapp.domain.Recipe;
import com.nikolai.recepieapp.services.RecipeService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @BeforeEach
    public void prepare() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void springMVCTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndexPage() {
        String expectedString = "index";

        Recipe firstRecipe = new Recipe();
        firstRecipe.setId(1L);
        firstRecipe.setDescription("Desc1");

        Recipe secondRecipe = new Recipe();
        secondRecipe.setId(4L);
        secondRecipe.setDescription("Desc2");

        Set<Recipe> expectedSet = new HashSet<>();
        expectedSet.add(firstRecipe);
        expectedSet.add(secondRecipe);

        Mockito.when(recipeService.getRecipes()).thenReturn(expectedSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String templateString = indexController.getIndexPage(model);

        assertEquals(templateString, expectedString);
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> actualSet = argumentCaptor.getValue();
        assertEquals(actualSet.size(), expectedSet.size());
    }
}