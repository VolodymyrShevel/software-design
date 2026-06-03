package com.library.repository;

import com.library.model.Book;
import java.util.List;

public interface BookRepositoryInterface extends Repository<Book, String> {
    List<Book> findAvailable();
    List<Book> findByGenre(String genre);
}