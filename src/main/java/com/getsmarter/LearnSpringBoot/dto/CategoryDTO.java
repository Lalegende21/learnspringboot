package com.getsmarter.LearnSpringBoot.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {

    private long id;

    private String name;
}
