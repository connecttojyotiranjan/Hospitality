package com.hospitality.auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospitality.auth.model.ApiResponse;
import com.hospitality.auth.model.LoginDetails;
import com.hospitality.auth.model.User;

public interface AuthService {

	public ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails);

	public Boolean validateToken(String token);
}
