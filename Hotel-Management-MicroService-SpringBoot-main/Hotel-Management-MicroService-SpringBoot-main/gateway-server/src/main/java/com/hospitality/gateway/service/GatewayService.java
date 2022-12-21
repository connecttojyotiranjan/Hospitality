package com.hospitality.gateway.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospitality.hospitality.model.ApiResponse;
import com.hospitality.hospitality.model.LoginDetails;
import com.hospitality.hospitality.model.User;

public interface GatewayService {
	public ResponseEntity<ApiResponse<User>> signUp(@RequestBody User user);

	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails);

}
