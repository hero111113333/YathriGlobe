package com.yathriglobe.authservice.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.authservice.dto.LoginRequestDto;
import com.yathriglobe.authservice.entity.User;
import com.yathriglobe.authservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController 
{
	
	private final AuthService authService;

    public AuthController(AuthService authService) 
    {
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public String register(@RequestBody User user) 
    {
        authService.register(user);
        return "User registered successfully";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto request) 
    {
    	System.out.println("LOGIN EMAIL => " + request.getEmail());
        System.out.println("LOGIN PASSWORD => " + request.getPassword());
        return authService.login(request);
    }

	
}
