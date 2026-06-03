package com.library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class User {
    private final String id;
    private String name;
    private String email;
    private final List<String> borrowedIsbns;

    public User(String id, String name, String email) {
        if (id == null || id.isBlank())       throw new IllegalArgumentException("User id cannot be blank");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Invalid email");
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedIsbns = new ArrayList<>();
    }

    public String getId()    { return id; }
    public String getName()  { return name; }
    public String getEmail() { return email; }
    public List<String> getBorrowedIsbns() { return Collections.unmodifiableList(borrowedIsbns); }

    public void setName(String name)   { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    public void addBorrow(String isbn)   { borrowedIsbns.add(isbn); }
    public void removeBorrow(String isbn){ borrowedIsbns.remove(isbn); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return Objects.equals(id, ((User) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("User{id='%s', name='%s', email='%s', borrowed=%s}", id, name, email, borrowedIsbns);
    }
}
