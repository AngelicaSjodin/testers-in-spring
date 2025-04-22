package com.example.testers;

public interface UserRepository {
    boolean exsistByUsername(String username);
    void save (User user);

    User findByUsername(String username);
}
