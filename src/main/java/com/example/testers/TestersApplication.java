package com.example.testers;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestersApplication.class, args);
	}

	@Test
	public void contextLoads(){

	}

}
