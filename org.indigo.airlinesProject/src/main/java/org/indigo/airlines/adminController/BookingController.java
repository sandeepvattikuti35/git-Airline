package org.indigo.airlines.adminController;

import java.util.List;

import org.indigo.airlines.adminService.AdminService;
import org.indigo.airlines.dto.BookingInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//to make use of REST API
@RequestMapping("/api/BookingInfo")
public class BookingController
{
	@Autowired
	private AdminService adminService;
	
	/*
	 * adding booking information data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addBookingInfo")
	public ResponseEntity<String> addBookingInformationData(@RequestBody BookingInfoDTO bookingInfoDTO)
	{
		System.out.println(bookingInfoDTO);
		int bookingid=adminService.addBookingInformation(bookingInfoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Booking Information id is "+bookingid);
		
	}
		//find bookingInfomration data by using BookingId
		@GetMapping("/findBookingInfo/{bookingid}")
		public ResponseEntity<BookingInfoDTO> findByBookingInfoDetails(@PathVariable("bookingid") int bid)
		{
			if (adminService.findByBookingDetailsById(bid)!=null) 
			{
				return ResponseEntity.status(HttpStatus.FOUND).body(adminService.findByBookingDetailsById(bid));
			} 
			else 
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			
		}
		
		//find all booking Information data byb using findall()method
		@GetMapping("/findAllBookingInfo")
		public List<BookingInfoDTO> getAllBookingInfoDetails()
		{
			return adminService.getAllBookingInfoDTOs();
			
		}
}
