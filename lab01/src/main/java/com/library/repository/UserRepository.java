package com.library.repository;

import com.library.model.User;

import java.util.*;

public class UserRepository implements Repository<User, String> {
    private final Map<String, User> store = new LinkedHashMap<>();

    @Override
    public void save(User user) {
        Objects.requireNonNull(user, "User must not be null");
        store.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
