package com.library.controller;

import com.library.service.LibraryService;

/**
 * Handles borrow/return operations only (SRP).
 */
public class BorrowController {
    private final LibraryService libraryService;

    public BorrowController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void borrow(String userId, String isbn) {
        libraryService.borrowBook(userId, isbn);
    }

    public void returnBook(String userId, String isbn) {
        libraryService.returnBook(userId, isbn);
    }
}
