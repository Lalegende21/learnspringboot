package com.getsmarter.LearnSpringBoot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "photo", nullable = false)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(name= "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;
}
