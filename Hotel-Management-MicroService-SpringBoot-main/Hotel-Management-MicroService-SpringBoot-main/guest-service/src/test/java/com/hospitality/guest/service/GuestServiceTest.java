package com.hospitality.guest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hospitality.guest.dto.CreditCardDto;
import com.hospitality.guest.dto.ProfileDto;
import com.hospitality.guest.dto.UserDto;
import com.hospitality.guest.entity.User;
import com.hospitality.guest.exception.GuestNotFoundException;
import com.hospitality.guest.mapper.UserMapperImpl;
import com.hospitality.guest.repository.GuestRepository;
import com.hospitality.guest.service.GuestServiceImpl;

class GuestServiceTest {

	@Mock
	private GuestRepository guestRepository;

	@InjectMocks
	private GuestServiceImpl guestService;

	private UserMapperImpl userMapperImpl;
	private User user;
	private UserDto userDto;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		userMapperImpl = new UserMapperImpl();
		userDto = new UserDto();
		userDto.setStatus(true);

		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1,1234567890L, "12/23", "Mahir", "Visa"));
		userDto.setCreditCards(creditCards);
		userDto.setProfile(new ProfileDto());
		user = userMapperImpl.convert(userDto);

	}

	@Test
	void addUserTest() {
		Mockito.when(guestRepository.save(user)).thenReturn(user);
		User userEntity = guestService.addUser(userDto);

		Assertions.assertAll(() -> assertNotNull(userEntity),
				() -> assertEquals(userEntity.getStatus(), userDto.getStatus()));

	}

	@Test
	void getUsersTest() {
		UserDto userDto = new UserDto();
		userDto.setStatus(true);

		List<CreditCardDto> creditCards = new ArrayList<>();
		creditCards.add(new CreditCardDto(1,1234567890L, "12/23", "Mahir", "Visa"));
		userDto.setCreditCards(creditCards);
		userDto.setProfile(new ProfileDto());

		List<User> users = new ArrayList<>();
		users.add(userMapperImpl.convert(userDto));

		Mockito.when(guestRepository.findByStatus(true)).thenReturn(users);

		List<User> actualUsers = guestService.getUsers();
		Assertions.assertNotNull(actualUsers);
		Assertions.assertTrue(actualUsers.size() > 0);

	}

	@Test
	void getUserById() {
		User user = userMapperImpl.convert(userDto);
		Optional<User> optionalUser = Optional.of(user);
		Mockito.when(guestRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalUser);

		User actualUser = guestService.getUserById(1);

		Assertions.assertAll(() -> assertNotNull(actualUser),
				() -> assertEquals(actualUser.getStatus(), userDto.getStatus()));
	}

	@Nested
	@DisplayName("Updated user test case")
	class UpdateUserTest {
		@Test
		void updateUserTest() {
			Optional<User> optionalUser = Optional.of(user);
			Mockito.when(guestRepository.findById(ArgumentMatchers.anyInt())).thenReturn(optionalUser);

			User userEntity = guestService.getUserById(1);
			userEntity.getProfile().setMobileNumber(8667688686L);
			Mockito.when(guestRepository.save(userEntity)).thenReturn(userEntity);

			User actualUser = guestService.updateUser(userDto, 1);
			Assertions.assertEquals(userEntity.getProfile().getMobileNumber(),
					actualUser.getProfile().getMobileNumber());
		}

		@Test
		void guestNotFoundException() {

			Optional<User> optionalUser = Optional.of(user);
			Mockito.when(guestRepository.findById(1)).thenReturn(optionalUser);

			User userEntity = guestService.getUserById(1);
			userEntity.getProfile().setMobileNumber(8667688686L);
			Mockito.when(guestRepository.save(userEntity)).thenReturn(userEntity);

			Assertions.assertThrows(GuestNotFoundException.class, () -> guestService.getUserById(100));
		}
	}

}
