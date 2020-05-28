package com.nikolai.recepieapp.domain;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

    private Category category;

    @BeforeEach
    public void prepare() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        Assert.assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String descriptionValue = "description";
        category.setDescription(descriptionValue);
        Assert.assertEquals(descriptionValue, category.getDescription());
    }
}