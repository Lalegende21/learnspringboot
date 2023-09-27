package com.getsmarter.LearnSpringBoot.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {

    private long id;

    private String photo;

    private String firstname;

    private String lastname;

    private String password;

    private String phoneNumber;

    private String email;

    /*private LocalDateTime created_at;

    private Timestamp updated_at;*/
}
