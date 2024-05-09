package com.oumaima.sharerecipe_backend.repository;

import com.oumaima.sharerecipe_backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
