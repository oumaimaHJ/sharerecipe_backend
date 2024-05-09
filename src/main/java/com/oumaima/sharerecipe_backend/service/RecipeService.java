package com.oumaima.sharerecipe_backend.service;

import com.oumaima.sharerecipe_backend.model.Recipe;
import com.oumaima.sharerecipe_backend.model.User;

import java.util.List;

public interface RecipeService {
    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipeById(Long id) throws Exception;
    public void deleteRecipe(Long id) throws Exception;
    public Recipe updateRecipe(Recipe recipe,Long id) throws Exception;
    public List<Recipe> findAllRecipe();
    public Recipe likeRecipe(Long recipeId, User user) throws Exception;


}
