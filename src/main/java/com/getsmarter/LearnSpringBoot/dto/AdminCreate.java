package com.getsmarter.LearnSpringBoot.dto;

import com.getsmarter.LearnSpringBoot.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
public class AdminCreate {

    private String firstname;

    private String lastname;

    private String password;

    private String phoneNumber;

    private String email;

}
