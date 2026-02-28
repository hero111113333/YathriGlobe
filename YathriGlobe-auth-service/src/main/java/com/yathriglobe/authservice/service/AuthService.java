package com.yathriglobe.authservice.service;

import com.yathriglobe.authservice.dto.LoginRequestDto;
import com.yathriglobe.authservice.entity.User;

public interface AuthService 
{
	void register(User user);
	String login(LoginRequestDto request);
}
