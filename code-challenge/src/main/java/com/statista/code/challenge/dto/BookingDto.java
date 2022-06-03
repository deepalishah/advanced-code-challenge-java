package com.statista.code.challenge.dto;

import java.math.BigDecimal;

import com.statista.code.challenge.model.Booking;
import com.statista.code.challenge.model.Department;

public class BookingDto {
	
	String description;
	BigDecimal price;
	String currency;
	long subscription_start_date;
	String email;
	String department;
	
    public void ConvertToBookingDto(Booking booking) {
    	
    	this.description = booking.getDescription();
    	this.price = booking.getPrice();
    	this.currency = booking.getCurrency();
    	this.subscription_start_date = booking.getSubscription_start_date();
    	this.email = booking.getEmail();
    	this.department = booking.getDepartment().name();	
    	
    }

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getSubscription_start_date() {
		return subscription_start_date;
	}
	public void setSubscription_start_date(long subscription_start_date) {
		this.subscription_start_date = subscription_start_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "BookingDto [description=" + description + ", price=" + price + ", currency=" + currency
				+ ", subscription_start_date=" + subscription_start_date + ", email=" + email + ", department="
				+ department + "]";
	}

}
