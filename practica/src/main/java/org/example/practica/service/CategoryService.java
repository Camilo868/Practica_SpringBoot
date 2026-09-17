package org.example.practica.service;

import org.example.practica.exceptions.ResourceNotFoundException;
import org.example.practica.exceptions.DuplicateResourceException;
import org.example.practica.model.Category;
import org.example.practica.model.Book;
import org.example.practica.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;




}
