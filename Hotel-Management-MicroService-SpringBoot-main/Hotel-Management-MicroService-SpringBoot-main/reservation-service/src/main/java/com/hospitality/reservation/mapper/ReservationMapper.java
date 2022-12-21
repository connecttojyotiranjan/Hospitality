package com.hospitality.reservation.mapper;


import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.hospitality.reservation.dto.ReservationDto;
import com.hospitality.reservation.entity.Reservation;

public class ReservationMapper implements Mapper{
	JMapper<Reservation,ReservationDto> jMapper;

	public ReservationMapper() {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Reservation.class));
		
		jMapper = new JMapper<>(Reservation.class, ReservationDto.class, api);
	}

	@Override
	public Reservation convert(ReservationDto reservationDto) {
		return jMapper.getDestination(reservationDto);
	}

}
