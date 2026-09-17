package org.example.practica.service;

import org.example.practica.exceptions.ResourceNotFoundException;
import org.example.practica.exceptions.DuplicateResourceException;
import org.example.practica.model.Book;
import org.example.practica.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }


    public Book findById(Long id) {
        // 1. Buscamos en la base de datos y guardamos el resultado en la "caja"
        Optional<Book> cajaLibro = bookRepository.findById(id);

        // 2. Comprobamos si la caja tiene el libro adentro
        if (cajaLibro.isPresent()) {
            // Si lo tiene, lo sacamos y lo devolvemos
            return cajaLibro.get();
        } else {
            // Si está vacía, lanzamos el error
            throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
        }
    }

    public Book create(Book book) {
        if (bookRepository.existsByTitle(book.getTitle())) {
            throw new DuplicateResourceException("El título del libro ya existe: " + book.getTitle());
        }
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. Libro no encontrado con ID: " + id);
        }
        bookRepository.deleteById(id);
    }

    public Book update(Long id, Book book) {
        // Al llamar a findById(id) aquí, automáticamente se ejecuta el "if" que creamos arriba.
        // Así que si no existe, lanzará el error antes de continuar.
        Book existingBook = findById(id);
        
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        
        return bookRepository.save(existingBook);
    }
}