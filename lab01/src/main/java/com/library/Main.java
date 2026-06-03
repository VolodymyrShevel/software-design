package com.library;

import com.library.controller.BookController;
import com.library.controller.BorrowController;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.LibraryService;
import com.library.util.Logger;

public class Main {
    public static void main(String[] args) {
        // --- Wiring ---
        Logger logger = new Logger();
        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        LibraryService service = new LibraryService(bookRepo, userRepo, logger);
        BookController bookController = new BookController(service);
        BorrowController borrowController = new BorrowController(service);

        // --- Seed data ---
        bookController.addBook("978-0-13-110362-7", "The C Programming Language", "Kernighan & Ritchie", "Programming", 1978);
        bookController.addBook("978-0-201-63361-0", "Design Patterns", "GoF", "Programming", 1994);
        bookController.addBook("978-0-13-468599-1", "Clean Code", "Robert C. Martin", "Programming", 2008);
        bookController.addBook("978-0-7432-7356-5", "1984", "George Orwell", "Fiction", 1949);

        service.registerUser(new User("u1", "Alice", "alice@example.com"));
        service.registerUser(new User("u2", "Bob",   "bob@example.com"));

        // --- Demo ---
        System.out.println("\n=== Available books ===");
        bookController.listAvailableBooks().forEach(System.out::println);

        System.out.println("\n=== Borrow: Alice takes 'Clean Code' ===");
        borrowController.borrow("u1", "978-0-13-468599-1");

        System.out.println("\n=== Available books after borrow ===");
        bookController.listAvailableBooks().forEach(System.out::println);

        System.out.println("\n=== Return: Alice returns 'Clean Code' ===");
        borrowController.returnBook("u1", "978-0-13-468599-1");

        System.out.println("\n=== Programming books ===");
        bookController.listBooksByGenre("Programming").forEach(System.out::println);

        System.out.println("\n=== Error handling demo ===");
        try {
            borrowController.borrow("u1", "978-0-13-468599-1");
            borrowController.borrow("u2", "978-0-13-468599-1"); // already taken
        } catch (IllegalStateException e) {
            logger.warn("Expected error: " + e.getMessage());
        }
    }
}
