package com.statista.code.challenge;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.statista.code.challenge.dto.BookingDto;
import com.statista.code.challenge.model.Business;
import com.statista.code.challenge.service.BookingService;

@Controller
@RequestMapping("/bookingservice")
public class FooBarController {
	
	@Autowired
	private BookingService bookingService;
        
	@PostMapping("/booking")
    public ResponseEntity<?> createBooking(@RequestBody  BookingDto bookingDto) {
		int result=bookingService.createBooking(bookingDto);
        return result==1?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
	
    @PutMapping("/booking/{booking_id}")
    public ResponseEntity<?> updateBooking(@RequestBody  BookingDto bookingDto, @PathVariable int booking_id) {
    	int result=bookingService.updateBooking(bookingDto, booking_id);
        return result==1?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
      
 
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable int bookingId) {
    	BookingDto result= bookingService.getBookingById(bookingId);	
    	return result==null?ResponseEntity.badRequest().build():new ResponseEntity<BookingDto>(result,HttpStatus.OK);
    }
    
    
    @GetMapping("/booking/type/{department}")
    public ResponseEntity<List<Integer>> getBookingsOfType(@PathVariable String department) {
    	List<Integer> resultList= bookingService.getBookingByDeptName(department);
    	return resultList==null?ResponseEntity.badRequest().build():new ResponseEntity<List<Integer>>(resultList,HttpStatus.OK);
    }  
    
    @GetMapping("/booking/type/currences")
    public ResponseEntity<List<String>> getBookingsByCurrencies() {
    	List<String> resultList= bookingService.getBookingByCurrencies();
    	return resultList==null?ResponseEntity.badRequest().build():new ResponseEntity<List<String>>(resultList,HttpStatus.OK);
    }   
    
    @GetMapping("/booking/sum/{currency}")
    public ResponseEntity<BigDecimal> getSum(@PathVariable String currency) {
    	BigDecimal result = bookingService.getSumOfPricesForCurrency(currency);
    	return result==null?ResponseEntity.badRequest().build():new ResponseEntity<BigDecimal>(result,HttpStatus.OK);
    }
    
    @GetMapping("/booking/dobusiness/{booking_id}")
    public ResponseEntity<Business> getBusinessAccoDepartment(@PathVariable int booking_id) {
    	Business result = bookingService.getBusinessAccoDepartment(booking_id);
    	return result==null?ResponseEntity.badRequest().build():new ResponseEntity<Business>(result,HttpStatus.OK);
    }
    
    
    
    
}