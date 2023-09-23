package org.indigo.airlines.adminController;

import org.indigo.airlines.adminService.AdminService;
import org.indigo.airlines.dto.PassengerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//make use of RESTAPI
@RequestMapping("/api/Passenger")
public class PassengerController
{

	@Autowired
	private AdminService adminService;
	
	/*
	 * adding checkIn data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addPassenger/{bookingId}/{checkInId}")
	public ResponseEntity<String> addPassengerData(@RequestBody PassengerDTO passengerDTO,
													@PathVariable("bookingId") int bookingId,
													@PathVariable("checkInId") int checkInId)
	{
		System.out.println(passengerDTO);
		int passengerid=adminService.addPassengerDetails(passengerDTO, bookingId, checkInId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Passenger id  is "+passengerid);
		
	}
}
