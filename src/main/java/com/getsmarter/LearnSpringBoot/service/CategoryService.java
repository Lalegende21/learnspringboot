package com.getsmarter.LearnSpringBoot.service;

import com.getsmarter.LearnSpringBoot.dto.CategoryDTO;
import com.getsmarter.LearnSpringBoot.entity.Category;
import com.getsmarter.LearnSpringBoot.repository.CategoryRepository;
import com.getsmarter.LearnSpringBoot.service.exception.CategoryNotFoundException;
import com.getsmarter.LearnSpringBoot.service.implement.CategoryServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    //Enregistrer une categorie
    @Override
    public CategoryDTO saveCategory(Category category) {
        category.setCreated_at(LocalDateTime.now());
        return convertCategoryToDto(this.categoryRepository.save(category));
    }


    //Afficher toutes les categories
    @Override
    public List<CategoryDTO> getAllCategory() {
        return this.categoryRepository.findAll().stream()
                .map(this::convertCategoryToDto)
                .collect(Collectors.toList());
    }


    //Afficher une categorie par son id
    @Override
    public Category getCategory(Long id) {
        Optional<Category> optionalCategory = this.categoryRepository.findById(id);
        return optionalCategory.orElseThrow(() -> new CategoryNotFoundException("Categorie ayant l'id " +id+ " pas trouvé !"));
    }



    //MAJ des données d'une categorie
    @Override
    public Category updateCategory( Long id ,Category category) {
        Category categoryUpdate = this.getCategory(id);

        if (categoryUpdate.getId() == category.getId()) {
           categoryUpdate.setName(category.getName());
           this.categoryRepository.save(categoryUpdate);
        }
        return categoryUpdate;
    }



    //Suppression de toutes les categories
    @Override
    public void deleteCategory() {
        this.categoryRepository.deleteAll();
    }



    //Suppression d'une categorie par id
    @Override
    public void deleteCategoryById(Long id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO convertCategoryToDto(Category c) {
        return CategoryDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

}
