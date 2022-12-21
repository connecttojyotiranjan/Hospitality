package com.hospitality.hotel.service;

import java.util.List;

import com.hospitality.hotel.dto.HotelDto;
import com.hospitality.hotel.entity.Hotel;

public interface HotelService {

	public Hotel addHotel(HotelDto hotelDto);

	public List<Hotel> getHotels();

	public Hotel getHotelById(int hotelId);

	public Hotel updateHotel(HotelDto hotelDto, int hotelId);

	public Hotel deleteHotel(int hotelId);

	public Hotel getHotelsByName(String name);

}
