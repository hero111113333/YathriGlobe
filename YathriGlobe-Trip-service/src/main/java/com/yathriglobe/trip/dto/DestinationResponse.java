package com.yathriglobe.trip.dto;

public class DestinationResponse 
{
	private Long id;
    private String name;
    private String country;
    private String description;
    private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "DestinationResponse [id=" + id + ", name=" + name + ", country=" + country + ", description="
				+ description + ", price=" + price + "]";
	}

}
