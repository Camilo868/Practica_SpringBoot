package org.example.practica.repository;


import org.example.practica.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    boolean existsByName(String name);

}
