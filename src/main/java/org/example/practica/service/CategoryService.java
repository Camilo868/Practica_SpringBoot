
package org.example.practica.service;

import org.example.practica.exceptions.ResourceNotFoundException;
import org.example.practica.exceptions.DuplicateResourceException;
import org.example.practica.model.Category;
import org.example.practica.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> cajaCategoria = categoryRepository.findById(id);
        if (cajaCategoria.isPresent()) {
            return cajaCategoria.get();
        } else {
            throw new ResourceNotFoundException("Categoría no encontrada con ID: " + id);
        }
    }

    public Category create(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new DuplicateResourceException("El nombre de la categoría ya existe: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. Categoría no encontrada con ID: " + id);
        }
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, Category category) {
        Category existingCategory = findById(id);

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);
    }
}
