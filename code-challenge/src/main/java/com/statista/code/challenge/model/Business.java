package com.statista.code.challenge.model;

import java.math.BigDecimal;

public class Business {
	
	String department;
	BigDecimal minPrice;
	
	public Business() {
		super();
		
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

}
