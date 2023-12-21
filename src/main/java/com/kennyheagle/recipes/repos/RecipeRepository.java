package com.kennyheagle.recipes.repos;

import org.springframework.data.repository.CrudRepository;

import com.kennyheagle.recipes.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}