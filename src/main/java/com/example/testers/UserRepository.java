package com.example.testers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByName(String name);

    User findByName(String name);
}
