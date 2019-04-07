package com.training.catalogueservice.com.training.catalogueservice.repository;


import com.training.catalogueservice.com.training.catalogueservice.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends MongoRepository <Category, String>{
}
