package com.statista.code.challenge.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;

public class Booking {
	
	int booking_id;
	String description;
	BigDecimal price;
	String currency;
	long subscription_start_date;
	String email;
	Department department;
	
	public Booking() {
		super();
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + booking_id;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (int) (subscription_start_date ^ (subscription_start_date >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (booking_id != other.booking_id)
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (department != other.department)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (subscription_start_date != other.subscription_start_date)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", description=" + description + ", price=" + price + ", currency="
				+ currency + ", subscription_start_date=" + subscription_start_date + ", email=" + email
				+ ", department=" + department + "]";
	}
	
	
	
}
	
