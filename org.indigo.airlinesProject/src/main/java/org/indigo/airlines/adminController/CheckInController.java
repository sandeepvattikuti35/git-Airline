package org.indigo.airlines.adminController;

import org.indigo.airlines.adminService.AdminService;
import org.indigo.airlines.dto.CheckInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//make use of RESTAPI
@RequestMapping("/api/CheckIn")
public class CheckInController 
{

	@Autowired
	private AdminService adminService;
	/*
	 * adding checkIn data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addCheckIn")
	public ResponseEntity<String> addCheckInData(@RequestBody CheckInDTO checkInDTO)
	{
		System.out.println(checkInDTO);
		int checkInid=adminService.addCheckInDetails(checkInDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("check In id is "+checkInid);
		
	}
	
	
}
