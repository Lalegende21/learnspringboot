package com.getsmarter.LearnSpringBoot.controller;

import com.getsmarter.LearnSpringBoot.entity.Product;
import com.getsmarter.LearnSpringBoot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // La methode pour inserer les produits
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Product product) {
        this.productService.saveProduct(product);
    }



    // La methodde pour lire les produits (Read du crud)
    @GetMapping()
    public List<Product> search() {
        return this.productService.getAllProduct();
    }



    // La methode pour lire les produits par id
    @GetMapping(path = "{id}")
    public Product read(@PathVariable Long id){
        return this.productService.getProduct(id);
    }



    // La methode pour modifier les données des produits
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}")
    public void update(@PathVariable long id, @RequestBody Product product) {
        this.productService.updateCategory(id, product);
    }


    // La methode pour supprimer tous les produits
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping()
    public void deleteAll() {
        this.productService.deleteProduct();
    }


    // La methode pour supprimer un produit par son identifiant
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        this.productService.deleteProductById(id);
    }
}
