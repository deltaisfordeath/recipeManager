package com.kennyheagle.recipes.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class User extends UpdatableEntity {

  private String firstName;

  private String lastName;

  private String username;

  private String password;

  private Instant lastLogin;

  @Enumerated(EnumType.STRING)
  private Role role;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String name) {
    this.firstName = name;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String name) {
    this.lastName = name;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Instant getLastLogin() {
    return this.lastLogin;
  }

  public void setLastLogin() {
    this.lastLogin = Instant.now();
  }

  public String getUsername() {
    return username;
  }

}