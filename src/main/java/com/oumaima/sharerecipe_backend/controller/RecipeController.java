package com.oumaima.sharerecipe_backend.controller;

import com.oumaima.sharerecipe_backend.model.Recipe;
import com.oumaima.sharerecipe_backend.model.User;
import com.oumaima.sharerecipe_backend.service.RecipeService;
import com.oumaima.sharerecipe_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe,
                     @RequestHeader("Authorization") String jwt) throws Exception{

        User user=userService.findUserByJwt(jwt);
        Recipe createdRecipe = recipeService.createRecipe(recipe, user);
        return createdRecipe;

    }

    @GetMapping
    public List<Recipe> getAllRecipe() throws Exception{

        List<Recipe> recipes= recipeService.findAllRecipe();
        return recipes;

    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception{
        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";

    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception{
        Recipe updatedRecipe = recipeService.updateRecipe(recipe,id);
        return updatedRecipe;
    }


    @PutMapping("/{id}/like")
    public Recipe likeRecipe( @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception{
        User user=userService.findUserByJwt(jwt);
        Recipe updatedRecipe=recipeService.likeRecipe(id, user);
        return updatedRecipe;
    }



}
