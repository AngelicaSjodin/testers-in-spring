package com.example.testers;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;




    public class UserControllerTest {

    private UserRepository mockedRepo;
    private UserService userService;
    private UserController userController;

    //runs this code once first
    @BeforeEach
    public void setUp(){
        mockedRepo = mock(UserRepository.class);
        userService = new UserService(mockedRepo);
        userController = new UserController(userService);
    }

    @AfterEach
    public void tearDown(){
        mockedRepo = null;
        userService = null;
        userController = null;
    }

    //component test
    // checks that the controller returns the correct response when a user is registered
    @Test
    public void registerShouldReturnString(){
        //Arrange is the setUp

        //hard-coding in a user
        User user = new User("Bill","bill@yahoo.com", 1L);
        when(mockedRepo.existsByName("Bill")).thenReturn(false);
        //Act
        String response = userController.registerUser(user).getBody();

        //Assert
        assertEquals("user registered", response);
        verify(mockedRepo).save(any(User.class));
    }

    //component test
    // checks that the copntroller returns a user with the correct name and email
    @Test
    public void getShouldReturnUser(){
        //Arrange is setUp

        //hard-coded in user
        User user = new User("Bill","bill@yahoo.com",2L);
        when(mockedRepo.findByName("Bill")).thenReturn(user);
        //Act
        User result = userController.getUser("Bill");
        //Assert
        assertEquals("Bill",result.getName());
        assertEquals("bill@yahoo.com",result.getEmail());
    }
}