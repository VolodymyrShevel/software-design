package com.library.controller;

import com.library.model.Book;
import com.library.service.LibraryService;

import java.util.List;

/**
 * Thin controller: only delegates to LibraryService.
 * Follows SRP — no business logic here.
 */
public class BookController {
    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void addBook(String isbn, String title, String author, String genre, int year) {
        Book book = new Book(isbn, title, author, genre, year);
        libraryService.addBook(book);
    }

    public List<Book> listAvailableBooks() {
        return libraryService.getAvailableBooks();
    }

    public List<Book> listBooksByGenre(String genre) {
        return libraryService.getBooksByGenre(genre);
    }
}
