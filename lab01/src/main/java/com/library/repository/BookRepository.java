package com.library.repository;

import com.library.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookRepository implements Repository<Book, String> {
    private final Map<String, Book> store = new LinkedHashMap<>();

    @Override
    public void save(Book book) {
        Objects.requireNonNull(book, "Book must not be null");
        store.put(book.getIsbn(), book);
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(store.get(isbn));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String isbn) {
        store.remove(isbn);
    }

    public List<Book> findByGenre(String genre) {
        return store.values().stream()
                .filter(b -> genre.equalsIgnoreCase(b.getGenre()))
                .collect(Collectors.toList());
    }

    public List<Book> findAvailable() {
        return store.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
