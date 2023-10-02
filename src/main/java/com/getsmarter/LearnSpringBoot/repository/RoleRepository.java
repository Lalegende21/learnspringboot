package com.getsmarter.LearnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.dto.AdminCreate;
import com.getsmarter.LearnSpringBoot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
