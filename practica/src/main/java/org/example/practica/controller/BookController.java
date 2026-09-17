package org.example.practica.controller;

import org.example.practica.model.Book;
import org.example.practica.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookService.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 para mostrar que se borró
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id) {

        if (book.getId() != null && !book.getId().equals(id)) {
            throw new IllegalArgumentException("El ID del cuerpo de la petición no coincide con el de la URL");
        }
        return bookService.update(id, book);
    }
}
