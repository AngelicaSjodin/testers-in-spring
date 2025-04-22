package com.example.testers;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

}
