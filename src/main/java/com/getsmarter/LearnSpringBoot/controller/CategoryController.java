package com.getsmarter.LearnSpringBoot.controller;

import com.getsmarter.LearnSpringBoot.dto.CategoryDTO;
import com.getsmarter.LearnSpringBoot.entity.Category;
import com.getsmarter.LearnSpringBoot.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    // La methode pour inserer les categories
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Category category) {
        this.categoryService.saveCategory(category);
    }


    // La methodde pour lire les utilisateurs (Read du crud)
    @GetMapping()
    public List<CategoryDTO> search() {
        return this.categoryService.getAllCategory();
    }


    // La methode pour lire les categories par id
    @GetMapping(path = "{id}")
    public Category read(@PathVariable Long id){
        return this.categoryService.getCategory(id);
    }


    // La methode pour modifier les données des categories
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}")
    public Category update(@PathVariable long id, @RequestBody Category category) {
        this.categoryService.updateCategory(id, category);
        return category;
    }


    // La methode pour supprimer toutes les categories
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping()
    public void deleteAll() {
        this.categoryService.deleteCategory();
    }


    // La methode pour supprimer une categorie par son identifiant
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        this.categoryService.deleteCategoryById(id);
    }
}
