package com.project.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.project.Authentication.entities.User;
import com.project.Authentication.exceptions.UserNotFoundException;
import com.project.Authentication.repositories.AuthenticationRepository;
import com.project.Authentication.services.AuthenticationService;

@DataJpaTest
public class AuthenticationCodeTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	private AuthenticationRepository authRepo;
 
	private User testUser;
	
	@BeforeEach
	private void Setup() {
		testUser = new User("riya", "riya@gmail.com", "riya123");
		System.out.println(testUser.toString());
		entityManager.persist(testUser);
		entityManager.flush();
	}

	@Test
	public void shouldGetUserByName() {
		User test = authService.GetUserByName("riya");
		assertEquals(testUser.getName(), test.getName());
	}

	@Test
	public void shouldFindUserByName() throws UserNotFoundException {
		Optional<User> temp = authRepo.findUserByName("riya");
		User tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertEquals(testUser.getName(), tempUser.getName());
		tempUser = new User();
		assertFalse(testUser.getName().equals(tempUser.getName()));
	}
	
	@Test
	public void shouldValidateUser() {
		// incorrect username
		User input = new User("riya", "BigEars");	
		Optional<User> temp = authRepo.findUserByName(input.getName());
		User tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertFalse(testUser.getName().equals(input.getName()));
		
		// incorrect password but correct username
		input.setName("riya");
		temp = authRepo.findUserByName(input.getName());
		tempUser = (temp.isPresent()) ? temp.get() : new User();
		assertFalse(authService.isValidPassword(tempUser.getPassword(), input.getPassword()));
		
		//correct username and password
		input.setPassword("riya123");
		assertTrue(authService.isValidPassword(tempUser.getPassword(), input.getPassword()));
	}

}
