package com.getsmarter.LearnSpringBoot.services;

import com.getsmarter.LearnSpringBoot.entity.Product;
import com.getsmarter.LearnSpringBoot.repository.ProductRepository;
import com.getsmarter.LearnSpringBoot.services.exception.ProductNotFoundException;
import com.getsmarter.LearnSpringBoot.services.implement.ProductServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceImpl {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // La methodde pour inserer les produits (Create du crud)
    @Override
    public Product saveProduct(Product product) {
        product.setCreated_at(LocalDateTime.now());
        this.productRepository.save(product);
        return product;
    }



    // La methodde pour lire les produits (Read du crud)
    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }



    // La methode pour lire les produits par id
    @Override
    public Product getProduct(Long id) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);

        return optionalProduct.orElseThrow(() -> new ProductNotFoundException("Produit ayant l'id " + id + " pas trouvé!"));
    }




    // La methode pour faire la mise à jour des données des produits
    @Override
    public Product updateCategory(Long id, Product product) {
        Product productUpdate = this.getProduct(id);

        if (productUpdate.getId() == product.getId()) {
            productUpdate.setPhoto(product.getPhoto());
            productUpdate.setName(product.getName());
            productUpdate.setQuantity(product.getQuantity());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setCategory(product.getCategory());
            this.productRepository.save(productUpdate);
        }
        return productUpdate;
    }




    // La methode pour supprimer tous les produits
    @Override
    public void deleteProduct() {
        this.productRepository.deleteAll();
    }




    // La methode pour supprimer un produit par son id
    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }
}
