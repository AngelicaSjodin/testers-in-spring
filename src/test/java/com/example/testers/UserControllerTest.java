package com.example.testers;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;


    class UserControllerTest {

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

}