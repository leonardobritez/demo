package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({})
public abstract class Auditable {


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate  // Automáticamente asigna la fecha de creación
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  // Automáticamente asigna la fecha de última actualización
    @Column(name = "updated_at")
    private Date updatedAt;

    // Getters y Setters
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;}
}