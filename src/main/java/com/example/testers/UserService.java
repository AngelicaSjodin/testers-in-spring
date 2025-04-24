package com.example.testers;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void registerUser(User user){
        if (repo.existsByUsername(user.getName())){
            throw new IllegalStateException("user already exists");
        }
        repo.save(user);
    }

    public User getUserByUsername(String username){
        return repo.findByUsername(username);
    }
}
