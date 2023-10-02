package com.getsmarter.LearnSpringBoot.service.implement;

import com.getsmarter.LearnSpringBoot.entity.Product;

import java.util.List;

public interface ProductServiceImpl {

    //Enregistrer un produit
    Product saveProduct(Product product);

    //Afficher les produits
    List<Product> getAllProduct();

    //Afficher un produit par son id
    Product getProduct(Long id);

    //MAJ des données du produit
    Product updateCategory( Long id ,Product product);

    //Suppression de tous les produits
    void deleteProduct();

    //Suppression d'un produit par id
    void deleteProductById(Long id);
}
