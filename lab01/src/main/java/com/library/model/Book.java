package com.library.model;

import java.util.Objects;

public class Book {
    private final String isbn;
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean available;

    public Book(String isbn, String title, String author, String genre, int year) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN cannot be blank");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be blank");
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.available = true;
    }

    public String getIsbn()       { return isbn; }
    public String getTitle()      { return title; }
    public String getAuthor()     { return author; }
    public String getGenre()      { return genre; }
    public int    getYear()       { return year; }
    public boolean isAvailable()  { return available; }

    public void setTitle(String title)   { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre)   { this.genre = genre; }
    public void setYear(int year)        { this.year = year; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return Objects.equals(isbn, ((Book) o).isbn);
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }

    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', author='%s', genre='%s', year=%d, available=%s}",
                isbn, title, author, genre, year, available);
    }
}
