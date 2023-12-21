package com.kennyheagle.recipes.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.PreUpdate;

@Entity
public class UpdatableEntity extends EntityBase {
    private Instant updatedAt;

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
}
