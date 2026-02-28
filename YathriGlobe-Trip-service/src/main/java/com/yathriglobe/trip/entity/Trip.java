package com.yathriglobe.trip.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trips")
public class Trip 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String email;
	    private Long destinationId;
	    private String destinationName;
	    private LocalDate travelDate;
	    private double price;
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
		public Long getDestinationId() {
			return destinationId;
		}
		public void setDestinationId(Long destinationId) {
			this.destinationId = destinationId;
		}
		public String getDestinationName() {
			return destinationName;
		}
		public void setDestinationName(String destinationName) {
			this.destinationName = destinationName;
		}
		public LocalDate getTravelDate() {
			return travelDate;
		}
		public void setTravelDate(LocalDate travelDate) {
			this.travelDate = travelDate;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Trip [id=" + id + ", email=" + email + ", destinationId=" + destinationId + ", destinationName="
					+ destinationName + ", travelDate=" + travelDate + ", price=" + price + "]";
		}

		
	    
	    
	
}
