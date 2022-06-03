package com.statista.code.challenge.model;


public enum Department {
	
	Cool_Department(1,"Cool_Department"),
	Food_Department(2,"Food_Department"),
	Clothes_Department(3, "Clothes_Department"),
    Furniture_Department(4,"Furniture_Department"),
	Jewellery_Department(5,"Jewellery_Department");

	private int id;
	private String deptName;

	Department(int id, String deptName) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.deptName=deptName;
		
	}
	
	
}