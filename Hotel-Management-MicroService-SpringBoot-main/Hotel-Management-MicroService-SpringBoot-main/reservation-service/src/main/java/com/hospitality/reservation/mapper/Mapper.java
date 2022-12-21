package com.hospitality.reservation.mapper;

import com.hospitality.reservation.dto.ReservationDto;
import com.hospitality.reservation.entity.Reservation;

public interface Mapper {
	public Reservation convert(ReservationDto reservationDto);
}
