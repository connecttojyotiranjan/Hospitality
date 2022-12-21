package com.hospitality.guest.mapper;

import com.hospitality.guest.dto.UserDto;
import com.hospitality.guest.entity.User;

public interface UserMapper {
   public User convert(UserDto userDto);
   public UserDto convert(User user);
}