package com.yathriglobe.authservice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yathriglobe.authservice.dto.LoginRequestDto;
import com.yathriglobe.authservice.entity.User;
import com.yathriglobe.authservice.repository.UserRepository;
import com.yathriglobe.authservice.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService
{

	private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder,JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil=jwtUtil;
    }
	
	
	@Override
	public void register(User user) 
	{
		if(repo.existsByEmail(user.getEmail()))
		{
			throw new RuntimeException("Email already exists");
		}
		user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        repo.save(user);
	}


	public String login(LoginRequestDto request) 
	{
        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) 
        {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }

}
