package com.yathriglobe.userprofileservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profiles")
public class UserProfile 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(unique = true, nullable = false)
    private String email;
    private String fullName;
    private String phone;
    private String country;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
    
	@Override
	public String toString() {
	    return "UserProfile{" +
	            "id=" + id +
	            ", email='" + email + '\'' +
	            ", fullName='" + fullName + '\'' +
	            ", phone='" + phone + '\'' +
	            ", country='" + country + '\'' +
	            '}';
	}

}
