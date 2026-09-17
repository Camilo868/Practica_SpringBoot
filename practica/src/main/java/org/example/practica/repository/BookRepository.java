package org.example.practica.repository;

import org.example.practica.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String tittle);
    boolean existsByTitle(String title);
}
