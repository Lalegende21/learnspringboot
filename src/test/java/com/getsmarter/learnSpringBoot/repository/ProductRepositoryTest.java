package com.getsmarter.learnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.entity.Product;
import com.getsmarter.LearnSpringBoot.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url = jdbc:mysql://localhost:3306/learnSpringBoottest?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC\n"
})
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testShouldReturnEmptyList(){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertEquals(1, products.size());
    }

    @Test
    public void testShouldShowSameProductName(){
        List<Product> products = productRepository.findAll();
        String name = products.get(0).getName();
        Assertions.assertEquals("bonbon", name);
    }
}
