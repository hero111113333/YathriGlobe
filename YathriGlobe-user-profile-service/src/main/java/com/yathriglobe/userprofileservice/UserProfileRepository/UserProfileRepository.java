package com.yathriglobe.userprofileservice.UserProfileRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yathriglobe.userprofileservice.entity.UserProfile;

public interface UserProfileRepository  extends JpaRepository<UserProfile,Long>
{
	Optional<UserProfile> findByEmail(String email);
}
