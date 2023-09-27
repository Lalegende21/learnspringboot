package com.getsmarter.LearnSpringBoot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "photo")
    private String photo;

    @Column(name = "firstname", length = 100, nullable = false)
    @Size(min = 3, max = 20, message = "Le nom doit être compris entre 3 et 20 caractères !")
    private String firstname;

    @Column(name = "lastname", length = 100, nullable = false)
    @Size(min = 3, max = 20, message = "Le prénom doit être compris entre 3 et 20 caractères !")
    private String lastname;

    @Column(name = "password", length = 100, nullable = false)
    @Size(min = 8, max = 30, message = "Le mot de passe doit être compris entre 8 et 30 caractères !")
    private String password;

    @Column(name = "phoneNumber", length = 100, unique = true, nullable = false)
    @Size(max = 10, message = "Le numéro de téléphone doit contenir exactement 10 chiffres")
    private String phoneNumber;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    @Size(max = 30, message = "L'email doit etre unique et etre contenu au plus 30 caractères !")
    private String email;

    @Column(name= "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;
}
