package com.kennyheagle.recipes.controllers;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kennyheagle.recipes.models.Recipe;
import com.kennyheagle.recipes.models.User;
import com.kennyheagle.recipes.repos.RecipeRepository;
import com.kennyheagle.recipes.repos.UserRepository;

class Thing {
  public String name;
  public int id;
  public String bollocks;
}

@Controller 
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RecipeRepository recipeRepository;

  // @GetMapping("/user")
  // public @ResponseBody Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
  //       return Collections.singletonMap("name", principal.getAuthorities());
  //   }

  @PostMapping(path="/user/add")
  public @ResponseBody String addNewUser (@RequestBody User user) {
    userRepository.save(user);
    return "Saved";
  }

  @GetMapping(path="/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    Iterable<User> users = userRepository.findAll();
    var iter = users.iterator();

    while(iter.hasNext()) {
      System.out.println(iter.next().getFullName());
    }

    return userRepository.findAll();
  }

  @GetMapping(path="/recipes")
  public @ResponseBody Iterable<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }

  @PostMapping(path="addrecipe")
  public @ResponseBody String addNewRecipe (@RequestBody Recipe recipe) {
      recipe.createdBy = 1;
      recipe.createdAt = Instant.now();
      recipeRepository.save(recipe);
      return "Saved";
  }

  @PutMapping(path="editrecipe/{id}")
  public @ResponseBody String editRecipe (@PathVariable("id") int id, @RequestBody Recipe recipe) {
      Optional<Recipe> existing = recipeRepository.findById(id);
      if (existing.isPresent()) {
        var updated = existing.get();
        updated.setName(recipe.getName());
        updated.setDescription(recipe.getDescription());
        updated.setCookingTime(recipe.getCookingTime());
        updated.setPrepTime(recipe.getPrepTime());
        updated.setDifficulty(recipe.getDifficulty());
        updated.setServings(recipe.getServings());
        updated.setImageUrl(recipe.getImageUrl());

        recipeRepository.save(recipe);
        return "Updated";
      }

      return "Recipe " + id +  " not found";
  }

  @DeleteMapping(path="deleterecipe/{id}")
  public @ResponseBody String deleteRecipe (@PathVariable("id") int id) {
    Optional<Recipe> existing = recipeRepository.findById(id);
    if (existing.isPresent()){
      recipeRepository.deleteById(id);
      return "Deleted";
    }

    return "Not Found";
  }

  // @DeleteMapping(path="/delete")
  // public @ResponseBody String deleteUser (@RequestBody) {
  //   //Optional<User> user  = userRepository.findById(thang.id);

  //   // if (user.isPresent()) {
  //   //   userRepository.deleteById(userId);
  //   //   return "User " + user.get().getName() + " was deleted!";
  //   // }
  //   // return "Not found.";
  // }

}