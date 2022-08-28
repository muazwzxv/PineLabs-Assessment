package com.pineLabs.PineLabsAssessment.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue
    protected UUID id;
    protected LocalDateTime createdAt;
    protected LocalDateTime deletedAt;

    @PrePersist
    public void generateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
