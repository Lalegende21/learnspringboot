package com.getsmarter.LearnSpringBoot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 30, unique = true, nullable = false)
    @Size(max = 30, message = "Le nom d'une categorie doit être unique et contenir au plus 30 caractères !")
    private String name;

    @Column(name= "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;
}
