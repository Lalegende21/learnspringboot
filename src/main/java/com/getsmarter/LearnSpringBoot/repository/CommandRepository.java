package com.getsmarter.LearnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
