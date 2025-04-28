package com.example.testers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    //removes data
    @BeforeEach
    public void cleanDatabase() {
        userRepository.deleteAll();
    }

    //integration test
    //tests whole controller chain, controller to service to repository to database
    @Test
    public void testRegisterAndRetrieverUser()throws Exception{
        User user = new User("Ange","ange@yahoo.com",null);


        //register User, checks it saves correctly
        mockMvc.perform(post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("user registered"));

        // Retrieve user, checks it retrieves correct data from teh database
        mockMvc.perform(get("/users/Ange"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ange"))
                .andExpect(jsonPath("$.email").value("ange@yahoo.com"));
    }
}
