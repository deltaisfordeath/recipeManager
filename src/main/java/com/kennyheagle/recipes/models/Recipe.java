package com.kennyheagle.recipes.models;

import jakarta.persistence.Entity;

@Entity
public class Recipe extends UpdatableEntity {

  private String name;
  private String description;
  private int cookingTime;
  private int prepTime;
  private int servings;
  private int difficulty;
  private String imageUrl;

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String newDescription) {
    this.description = newDescription;
  }

  public int getCookingTime() {
    return this.cookingTime;
  }

  public void setCookingTime(int newTime) {
    this.cookingTime = newTime;
  }

  public int getPrepTime() {
    return this.prepTime;
  }

  public void setPrepTime(int newTime) {
    this.prepTime = newTime;
  }

  public int getServings() {
    return this.servings;
  }
  
  public void setServings(int newServings) {
    this.servings = newServings;
  }

  public int getDifficulty() {
    return this.difficulty;
  }

  public void setDifficulty(int newDifficulty) {
    this.difficulty = newDifficulty;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String newImageUrl) {
    this.imageUrl = newImageUrl;
  }
}
