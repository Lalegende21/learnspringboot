package com.getsmarter.LearnSpringBoot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "photo")
    private String photo;

    @Column(name = "name", length = 100, nullable = false)
    @Size(max = 50, message = "Le nom doit contenir au plus 50 caractères !")
    private String name;

    @Column(name = "quantity", length = 100, nullable = false)
    private int quantity;

    @Column(name = "price", length = 100, nullable = false)
    private long price;

    @Column(name = "description", length = 100, nullable = false)
    @Size(max = 250, message = "La description doit contenir au plus 250 caractères !")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name= "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

}
