package com.getsmarter.LearnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
