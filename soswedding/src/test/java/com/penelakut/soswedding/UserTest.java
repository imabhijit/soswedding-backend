package com.penelakut.soswedding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import java.util.Optional;
import com.penelakut.soswedding.model.User;
import com.penelakut.soswedding.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	public UserTest() {}

	@Mock
	UserRepository repository;
	
	@Test
	public void getUserByFirstName() {
		Optional<User> mockList = Optional.empty();
		assertEquals(repository.findUserByFirstName(any()), mockList);
    }
    
    @Test
	public void getUserByUuid() {
		Optional<User> mockList= Optional.empty();
		assertEquals(repository.findUserByUuid(any()), mockList);
	}
	
}
