package com.grade.project.application.command;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FiltersObjectCommandTest {

    @Test
    public void createCommandWithEmptyConstructor() {
        FiltersObjectCommand filtersObjectCommand = new FiltersObjectCommand();
    }

    @Test
    public void createCommandWithConstructor() {
        FiltersObjectCommand filtersObjectCommand = new FiltersObjectCommand("Celular", new ArrayList<>(), new ArrayList<>());
        Assert.assertEquals("Celular", filtersObjectCommand.getSearchWord());
        Assert.assertTrue(filtersObjectCommand.getObjectTypes().isEmpty());
        Assert.assertTrue(filtersObjectCommand.getObjectStatuses().isEmpty());
    }
}
