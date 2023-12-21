package com.kennyheagle.recipes.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public abstract class EntityBase {
    @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;
    public int createdBy;
    public Instant createdAt;

    @PrePersist
    public void onCreate() {
      this.createdAt = Instant.now();
    }

    public int getId() {
      return this.Id;
    }

    protected void setId(int newId) {
      this.Id = newId;
    }
}
