package com.example.testers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    //ref to service
    private final UserService userService;

    //const
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "user registered";
    }

}
