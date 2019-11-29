package com.penelakut.soswedding;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.penelakut.soswedding.controller.UserAPI;
import com.penelakut.soswedding.model.User;
import com.penelakut.soswedding.model.UserType;
import com.penelakut.soswedding.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserAPITest {

	public UserAPITest() {}

	@InjectMocks
	UserAPI userAPI;

	@Mock
	UserRepository userRepository;

	@Mock
	User mockUser;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockUser = new User();
		mockUser.setId(1L);
		mockUser.setFirstName("Rodrigo");
		mockUser.setUuid("uuid");
		mockUser.setEmailAddress("test@email.com");
		mockUser.setType(UserType.COUPLE);
		when(userRepository.findUserByFirstName(any())).thenReturn(Optional.of(mockUser));
		when(userRepository.findUserByUuid(any())).thenReturn(Optional.of(mockUser));
	}

	@Test
	public void getUserByFirstName() {
		User user = userAPI.getUserByFirstName(mockUser.getFirstName());
		assertEquals(user.getFirstName(), mockUser.getFirstName());
		verify(userRepository).findUserByFirstName(any());
    }

    @Test
	public void getUserByUuid() {
		User user = userAPI.getUserByUUID(mockUser.getUuid());
		assertEquals(user.getUuid(), mockUser.getUuid());
		verify(userRepository).findUserByUuid(any());
	}

}
