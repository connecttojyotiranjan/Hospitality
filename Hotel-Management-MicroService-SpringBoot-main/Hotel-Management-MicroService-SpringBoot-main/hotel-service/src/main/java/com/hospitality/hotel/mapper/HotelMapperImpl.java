package com.hospitality.hotel.mapper;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.hospitality.hotel.dto.HotelDto;
import com.hospitality.hotel.entity.Hotel;

@Component
public class HotelMapperImpl implements HotelMapper{

	@Override
	public Hotel convert(HotelDto hotelDto) {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(Hotel.class));
		JMapper<Hotel,HotelDto> jMapper = new JMapper<>(Hotel.class, HotelDto.class, api);
		return jMapper.getDestination(hotelDto);
	}

	@Override
	public HotelDto convert(Hotel hotel) {
		JMapperAPI api = new JMapperAPI()
				.add(JMapperAPI.mappedClass(HotelDto.class));
		JMapper<HotelDto,Hotel> jMapper = new JMapper<>(HotelDto.class, Hotel.class, api);
		return jMapper.getDestination(hotel);
	}
}
