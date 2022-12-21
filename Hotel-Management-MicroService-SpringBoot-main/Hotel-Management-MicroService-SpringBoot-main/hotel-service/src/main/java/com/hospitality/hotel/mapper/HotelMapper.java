package com.hospitality.hotel.mapper;

import com.hospitality.hotel.dto.HotelDto;
import com.hospitality.hotel.entity.Hotel;

public interface HotelMapper {
	
   public Hotel convert(HotelDto userDto);
   
   public HotelDto convert(Hotel hotel);
   
}