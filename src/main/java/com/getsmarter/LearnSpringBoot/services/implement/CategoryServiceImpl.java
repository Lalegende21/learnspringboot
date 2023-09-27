package com.getsmarter.LearnSpringBoot.services.implement;

import com.getsmarter.LearnSpringBoot.dto.CategoryDTO;
import com.getsmarter.LearnSpringBoot.entity.Category;

import java.util.List;

public interface CategoryServiceImpl {

    //Enregistrer une categorie
    CategoryDTO saveCategory(Category category);

    //Afficher les categories
    List<CategoryDTO> getAllCategory();

    //Afficher une categorie par son id
    Category getCategory(Long id);

    //MAJ des données de la categorie
    Category updateCategory( Long id ,Category category);

    //Suppression de toutes les categories
    void deleteCategory();

    //Suppression d'une categorie par id
    void deleteCategoryById(Long id);


    //Conversion d'une categorie en categorieDTO
    CategoryDTO convertCategoryToDto(Category c);
}
