package com.hospitality.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.auth.model.ApiResponse;
import com.hospitality.auth.model.LoginDetails;
import com.hospitality.auth.model.User;
import com.hospitality.auth.service.AuthService;

@RestController
public class AuthControllerImpl implements AuthController {

	@Autowired
	private AuthService authService;

	@Override
	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails) {
		return authService.login(loginDetails);
	}

	@Override
	public Boolean validateToken(String token) {

		return authService.validateToken(token);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> signUp(User user) {
		return authService.signUp(user);
	}

}
