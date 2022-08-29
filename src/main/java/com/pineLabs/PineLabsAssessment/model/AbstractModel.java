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
    protected LocalDateTime created_on;
    protected LocalDateTime updated_on;
    protected LocalDateTime deleted_on;

    @PrePersist
    public void setCreated_on() {
        this.created_on = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdated_on() {
        this.updated_on = LocalDateTime.now();
    }
}
