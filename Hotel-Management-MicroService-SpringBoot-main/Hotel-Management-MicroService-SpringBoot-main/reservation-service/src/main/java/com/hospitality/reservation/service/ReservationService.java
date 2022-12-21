package com.hospitality.reservation.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hospitality.reservation.dto.ReservationDto;
import com.hospitality.reservation.entity.Reservation;
import com.hospitality.reservation.exception.ReservationNotFoundException;
import com.hospitality.reservation.model.ApiResponse;

public interface ReservationService {

	public ResponseEntity<ApiResponse<Reservation>> addReservation(ReservationDto reservation);

	public Reservation getReservationDetailsById(int anyInt) throws ReservationNotFoundException;

	public List<Reservation> getAllReservations();
	
	public Reservation cancelReservation(ReservationDto reservation,int anyInt);

}
