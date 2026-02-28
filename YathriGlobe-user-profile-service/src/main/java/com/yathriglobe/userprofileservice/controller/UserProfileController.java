package com.yathriglobe.userprofileservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.userprofileservice.UserProfileRepository.UserProfileRepository;
import com.yathriglobe.userprofileservice.entity.UserProfile;
import com.yathriglobe.userprofileservice.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserProfileController 
{
	private final UserProfileRepository repo;
	private final JwtUtil jwtUtil;

    public UserProfileController(UserProfileRepository repo,JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/profiles")
    public UserProfile createProfile(
            @RequestBody UserProfile profile,
            @RequestHeader("Authorization") String authHeader) {

    	if (!authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Invalid Authorization header");
        }
        String token = authHeader.substring(7);
        String email = jwtUtil.extractEmail(token);

        profile.setEmail(email);
        return repo.save(profile);
    }

    @GetMapping("/profiles")
    public UserProfile getProfile(
            @RequestHeader("Authorization") String authHeader) {

        // 1. Remove "Bearer "
        String token = authHeader.substring(7);

        // 2. Validate token
        if (!jwtUtil.validateToken(token)) {
            throw new RuntimeException("Invalid JWT");
        }

        // 3. Extract email
        String email = jwtUtil.extractEmail(token);

        // 4. Fetch profile
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
