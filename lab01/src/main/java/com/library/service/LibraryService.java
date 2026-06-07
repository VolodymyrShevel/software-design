package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.Repository;
import com.library.repository.BookRepositoryInterface;
import com.library.util.ILogger;

import java.util.List;

/**
 * Core business logic for borrowing/returning books.
 * Follows SRP: handles only borrow/return operations.
 */
public class LibraryService {

    private static final int MAX_BORROWS = 5;

    private final BookRepositoryInterface bookRepository;
    private final Repository<User, String> userRepository;
    private final ILogger logger;

    public LibraryService(BookRepositoryInterface bookRepository,
                      Repository<User, String> userRepository,
                      ILogger logger) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.logger = logger;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
        logger.info("Book added: " + book.getIsbn());
    }

    public void registerUser(User user) {
        userRepository.save(user);
        logger.info("User registered: " + user.getId());
    }

    /**
     * Borrow a book. Throws if not available or borrow limit reached.
     */
    public void borrowBook(String userId, String isbn) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        Book book = bookRepository.findById(isbn)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + isbn));

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available: " + isbn);
        }
        if (user.getBorrowedIsbns().size() >= MAX_BORROWS) {
            throw new IllegalStateException("User has reached borrow limit (" + MAX_BORROWS + ")");
        }

        book.setAvailable(false);
        user.addBorrow(isbn);
        logger.info(String.format("User '%s' borrowed book '%s'", userId, isbn));
    }

    /**
     * Return a previously borrowed book.
     */
    public void returnBook(String userId, String isbn) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));

        Book book = bookRepository.findById(isbn)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + isbn));

        if (!user.getBorrowedIsbns().contains(isbn)) {
            throw new IllegalStateException("User has not borrowed this book: " + isbn);
        }

        book.setAvailable(true);
        user.removeBorrow(isbn);
        logger.info(String.format("User '%s' returned book '%s'", userId, isbn));
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailable();
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
}
