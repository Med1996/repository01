package com.training.catalogueservice;

import com.training.catalogueservice.com.training.catalogueservice.entities.Category;
import com.training.catalogueservice.com.training.catalogueservice.entities.Product;
import com.training.catalogueservice.com.training.catalogueservice.repository.CategoryRepository;
import com.training.catalogueservice.com.training.catalogueservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueServiceApplication.class, args);

    }
    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository){
        return args -> {
            categoryRepository.deleteAll();
            Stream.of("C1 Ordinateur", "C2 Imprimante" ).forEach(c -> {
                categoryRepository.save(new Category(c.split(" ") [0], c.split(" ") [1], new ArrayList<>() )
                );
            });
          //  categoryRepository.findAll().forEach(System.out :: println);

            productRepository.deleteAll();

            Category c1 = categoryRepository.findById("C1").get();
            Stream.of("P1","P2").forEach( p -> {
               Product product1 = productRepository.save(new Product(null, p, Math.random()*1000, c1));
                c1.getProducts().add(product1);
                categoryRepository.save(c1);
            });

            Category c2 = categoryRepository.findById("C2").get();
            Stream.of("P5","P6").forEach( p2 -> {
                Product product2 = productRepository.save(new Product(null, p2, Math.random()*1000, c2));
                c2.getProducts().add(product2);
                categoryRepository.save(c2);
            });

          //  productRepository.findAll().forEach(System.out :: println);
        };
    }
}

