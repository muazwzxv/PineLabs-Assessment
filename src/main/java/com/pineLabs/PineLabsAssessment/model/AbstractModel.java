package com.pineLabs.PineLabsAssessment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    protected Long id;

    @JsonProperty("created_on")
    protected LocalDateTime created_on;

    @JsonProperty("updated_on")
    protected LocalDateTime updated_on;

    @JsonProperty("deleted_on")
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
