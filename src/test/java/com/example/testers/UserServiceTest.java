package com.example.testers;

import org.junit.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    //two unit test with mockito

    @Test
    //checks registerUser() throws an exception and does not save a user if the
    //username is already taken
    public void ChecksIfRegisterUserMethodStopsIfTheUsernameIsAlreadyTaken(){
        //Arrange

            //makes repo mocked to avoid using the real database when testing
        UserRepository mockRepo = mock(UserRepository.class);

            //injects mocked repo to service aka dependency injection
        UserService service = new UserService(mockRepo);

            //hard-coded
        User user = new User("Angelica","Angelica@test.com",null);

            //makes user  angelica already exist by telling mock to return true when mwthod is called
        when(mockRepo.existsByName("Angelica")).thenReturn(true);

        //Act & Assert

            //calling method, expect ut to throw illegalStateEception
            //if it does not the test fails
        Exception exception = assertThrows(IllegalStateException.class,()->{
            service.registerUser(user);
        });

        assertEquals("user already exists", exception.getMessage());
        verify(mockRepo, never()).save(any(User.class));

    }

    @Test
    //checks what happens if a username is not found, in that case it should return null
    public void ChecksIfGetUserByUsernameMethodStopsIfTheUsernameIsMissing(){
        //Arrange


        UserRepository mockRepo = mock(UserRepository.class);

        UserService service = new UserService(mockRepo);

            //no user is found when there is "missingUser"
        when(mockRepo.findByName("missingUser")).thenReturn(null);

        //Act
            //calling service method
        User result = service.getUserByName("missingUser");

        //Assert
            //when repo return null so does servicee
        assertNull(result);
    }

}