package org.example.practica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore // CRÍTICO: Evita un bucle infinito al convertir a JSON (Categoría llama a Libro, Libro a Categoría...)
    private List<Book> books;
}
