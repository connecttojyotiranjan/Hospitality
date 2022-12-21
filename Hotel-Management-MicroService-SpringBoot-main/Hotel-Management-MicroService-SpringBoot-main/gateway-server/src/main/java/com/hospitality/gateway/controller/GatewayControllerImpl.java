package com.hospitality.gateway.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.gateway.service.GatewayService;
import com.hospitality.hospitality.model.ApiResponse;
import com.hospitality.hospitality.model.LoginDetails;
import com.hospitality.hospitality.model.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GatewayControllerImpl implements GatewayController {

	@Autowired
	private GatewayService gatewayService;

	@Override
	public ResponseEntity<ApiResponse<String>> login(LoginDetails loginDetails) {
		log.info("Entired into the " + GatewayControllerImpl.class.getName() + "login Method");
		return gatewayService.login(loginDetails);
	}

	public ResponseEntity<ApiResponse<String>> loginFallback(LoginDetails loginDetails, Exception e) {
		log.info("Entired into the loginFallback Mrthod" + GatewayControllerImpl.class.getName());
		return new ResponseEntity<>(new ApiResponse<>("guest-service is down", new Date(), e.getMessage()),
				HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public ResponseEntity<ApiResponse<User>> signUp(User user) {
		log.info("Entired into the " + GatewayControllerImpl.class.getName() + "signUp");
		return gatewayService.signUp(user);
	}

}
