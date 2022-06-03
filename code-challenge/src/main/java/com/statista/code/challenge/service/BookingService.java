package com.statista.code.challenge.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.statista.code.challenge.dto.BookingDto;
import com.statista.code.challenge.model.Booking;
import com.statista.code.challenge.model.Business;
import com.statista.code.challenge.model.Department;

@Service
public class BookingService {
	
	static Logger logger=Logger.getLogger(BookingService.class.getName());
	
	List<Booking> bookingList;
	List<BookingDto> bookingDtoList;
	static int bookingIdGenerator=0;
	
	public BookingService(List<Booking> bookings)
	{
		this.bookingList=bookings;
	}
	
	
	public int createBooking(BookingDto bookingDto)
	{
		try {
		Booking booking=new Booking();
		booking.setBooking_id(++bookingIdGenerator);
		booking.setCurrency(bookingDto.getCurrency());
		booking.setDepartment(getDepartment(bookingDto.getDepartment()));
		booking.setDescription(bookingDto.getDescription());
		booking.setEmail(bookingDto.getEmail());
		booking.setPrice(bookingDto.getPrice());
		booking.setSubscription_start_date(bookingDto.getSubscription_start_date());
		
		bookingList.add(booking);
		
		logger.info("Booking record added in the list");
		System.out.println(booking.toString());
		sendEmail(bookingDto.getEmail(),"deepalipshah2@gmail.com","Confirmation of Booking","Booking has been confimed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
	public Department getDepartment(String department) {
	
		if(Department.Food_Department.name().equalsIgnoreCase(department))
			return Department.Food_Department;
		else if(Department.Cool_Department.name().equalsIgnoreCase(department))
			return Department.Cool_Department;
		else if(Department.Clothes_Department.name().equalsIgnoreCase(department))
			return Department.Clothes_Department;
		else if(Department.Furniture_Department.name().equalsIgnoreCase(department))
			return Department.Furniture_Department;
		else if(Department.Jewellery_Department.name().equalsIgnoreCase(department))
			return Department.Jewellery_Department;
		else
		return null;
	}


	public int updateBooking(BookingDto bookingDto,int booking_id)
	{
	try {		
		
		
		Booking booking=new Booking();
		booking.setCurrency(bookingDto.getCurrency());
		booking.setDepartment(getDepartment(bookingDto.getDepartment()));
		booking.setDescription(bookingDto.getDescription());
		booking.setEmail(bookingDto.getEmail());
		booking.setPrice(bookingDto.getPrice());
		booking.setSubscription_start_date(bookingDto.getSubscription_start_date());
		Booking existingBookingRecord =bookingList.stream().filter(book->book.getBooking_id()==booking_id).findAny().orElse(null);
		
		if(existingBookingRecord==null)
		{
			booking.setBooking_id(++bookingIdGenerator);
			
		}
		else
		{
			existingBookingRecord=booking;
			existingBookingRecord.setBooking_id(booking_id);
		}
		
		bookingList.add(booking);
	}
		 catch (Exception e) {
           e.printStackTrace();
	
		}
		return 1;
	}
	
	public void sendEmail(String to,String from,String subject,String msg) 
	{  try
	    {
		  if(to != null && from != null && subject != null && msg !=null) {
			  logger.info("Mail has been sent");
		   }
		}
	    catch (NullPointerException e) {
	    	e.printStackTrace();
	    }
				   		
	}
	
	
	
	public BookingDto getBookingById(int booking_id)
	{
	  BookingDto bookingDto = new BookingDto();
	  try {	
	
		  for(Booking booking : bookingList) {
			  
		  if(booking.getBooking_id() ==  booking_id) 
		  {
		   bookingDto.ConvertToBookingDto(booking);
		  
           logger.info("Booking by Id");
           
	      }
         }
	  }
	  catch (Exception e) {
			e.printStackTrace();
			}
	       return bookingDto;
	   	 
    }
	
	public List<Integer> getBookingByDeptName(String deptName)
	{
		List<Integer> bookingIds=new ArrayList<>();
		try {
	
			if(bookingList!=null)
				bookingIds=bookingList.stream().filter(booking->booking.getDepartment().name().
						   equalsIgnoreCase(deptName)).map(booking->booking.getBooking_id()).collect(Collectors.toList());
			
		}
		 catch (Exception e) {
				e.printStackTrace();	
				}
		
		return bookingIds; 
				
	}
	
	public List<String> getBookingByCurrencies()
	{
		List<String> currencieslist=new ArrayList<>();
		try {
	
			currencieslist=bookingList.stream().map(booking->booking.getCurrency()).distinct().collect(Collectors.toList());
		
		}
		catch (Exception e) {
				e.printStackTrace();
					
				}
		
		return currencieslist;		
	}
	
	public BigDecimal getSumOfPricesForCurrency(String currency) {
		
		BigDecimal sum = new BigDecimal(0.0);
		try {
			logger.info("bookingList"+bookingList.size());
		for(Booking booking : bookingList) { 
		    
			if(booking.getCurrency().equalsIgnoreCase(currency)) {
	
			    sum=sum.add(booking.getPrice());
			  }
        }
		}
		catch (Exception e) {
			e.printStackTrace();
				
			}
		return sum;
	}


	public Business getBusinessAccoDepartment(int booking_id) {
		// TODO Auto-generated method stub
    
		Booking bookingRecord=bookingList.stream().filter(booking->booking.getBooking_id()==booking_id).findAny().orElse(null);
		if(bookingRecord!=null)
		{
			return doBusiness(bookingRecord.getDepartment().name());
		}
		return null;
		
	}


	public Business doBusiness(String name) {
		
        Business business = new Business();
		switch(name)
		{
			case "Cool_Department": 
				  logger.info("Refrigerator, Cooler and Fans these items are there in department");
				  business.setDepartment("Cool_Department");
				  business.setMinPrice(MinPrice(name));
				  
			case "Food_Department":
				  logger.info("Bread, Jam, Cheese, Pizza, Burger these items are there in department");
				  business.setDepartment("Food_Department");
				  business.setMinPrice(MinPrice(name));
				  
			case "Clothes_Department":
				  logger.info("Woolen Clothes, Rainy wear these items are there in department");
				  business.setDepartment("Clothes_Department");
				  business.setMinPrice(MinPrice(name));
				  
			case "Furniture_Department":
				  logger.info("Woolen Clothes, Rainy wear these items are there in department");
				  business.setDepartment("Furniture_Department");
				  business.setMinPrice(MinPrice(name));
				  
			case "Jewellery_Department":
				  logger.info("Woolen Clothes, Rainy wear these items are there in department");	
				  business.setDepartment("Jewellery_Department");
				  business.setMinPrice(MinPrice(name)); 
				  
		}
		
		return business;
	
	}
		
	public BigDecimal MinPrice(String name) {
			
		BigDecimal price = new BigDecimal(80.00);
		if(name.equalsIgnoreCase("Cool_Department")) {
			price = new BigDecimal(80.00);
		}
		else if(name.equalsIgnoreCase("Food_Department")) {
			price = new BigDecimal(60.00);
		} 
		else if(name.equalsIgnoreCase("Clothes_Department")) {
			price = new BigDecimal(120.00);
		}
        else if(name.equalsIgnoreCase("Furniture_Department")) {
            price = new BigDecimal(150.00);
		}
        else if(name.equalsIgnoreCase("Jewellery_Department")) {
            price = new BigDecimal(140.00);
		}
        return price;
	}
	
	

}
