package com.getsmarter.LearnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {


}
