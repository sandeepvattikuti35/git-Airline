package org.indigo.airlines.adminController;

import org.indigo.airlines.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//to make use of REST API
@RequestMapping("/api/Flights")
public class FlightController
{
	@Autowired
	private AdminService adminService;

	/*
	 * getting flight details based on starting location ,destination,flightdate,flightname
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
}
