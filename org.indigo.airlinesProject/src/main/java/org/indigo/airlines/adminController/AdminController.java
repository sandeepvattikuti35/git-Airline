package org.indigo.airlines.adminController;

import java.util.List;

import org.indigo.airlines.adminService.AdminService;
import org.indigo.airlines.dto.AirlineDTO;
import org.indigo.airlines.dto.BookingInfoDTO;
import org.indigo.airlines.dto.CheckInDTO;
import org.indigo.airlines.dto.FareDTO;
import org.indigo.airlines.dto.FlightDTO;
import org.indigo.airlines.dto.FlightInfoDTO;
import org.indigo.airlines.dto.InventoryDTO;
import org.indigo.airlines.dto.PassengerDTO;
import org.indigo.airlines.dto.UserDTO;
import org.indigo.airlines.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//using of restAPI
@RequestMapping("/api/admin")
public class AdminController
{
	@Autowired
	private AdminService adminService;
	/*
	 * adding airline data 
	 * Create an api add details in db
	 * to take input from postman in the form of java object 
	 */
	@PostMapping("/addAirlineInfo")
	public ResponseEntity<String> addAirlineInfo(@RequestBody AirlineDTO airlineDTO)
	{
		System.out.println(airlineDTO);
		int airlineid= adminService.addAirlineInformation(airlineDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Airline Id is "+airlineid);
		
	}
	/*
	 * adding flightInfo data 
	 * Create an api add details in db
	 * to take input from postman in the form of java object 
	 */	
	@PostMapping("/addFlightInfo/{airlineId}")
	public ResponseEntity<String> addFlightInfo(@RequestBody FlightInfoDTO flightInfoDTO , @PathVariable("airlineId") int airlineId)
	{
		System.out.println(flightInfoDTO);
		int fi=adminService.addFlightInfo(flightInfoDTO, airlineId);
		return ResponseEntity.status(HttpStatus.CREATED).body("flightInfo id is "+ fi);
		
	}
	/*
	 * adding fare data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addFare")
	public ResponseEntity<String> addfareData(@RequestBody FareDTO fareDTO)
	{
		System.out.println(fareDTO);
		int fareid=adminService.addFareDetails(fareDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Fare id is "+fareid);
		
	}
	/*
	 * adding fare data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addInventory")
	public ResponseEntity<String> addInventoryData(@RequestBody InventoryDTO inventoryDTO)
	{
		System.out.println(inventoryDTO);
		int inventoryid=adminService.addInventoryDetails(inventoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("inventory id is "+inventoryid);
		
	}
	/*
	 * adding flight data into database
	 * create an api  add details in db
	 * to take input from postman in th form of java object
	 */
	@PostMapping("/addFlight/{fareId}/{flightInfoId}/{InventoryId}")
	public ResponseEntity<String> addFlightData(@RequestBody FlightDTO flightDTO,
												@PathVariable("fareId") int fareId,
												@PathVariable("flightInfoId") int flightInfoId,
												@PathVariable("InventoryId") int inventoryId)
	{
		System.out.println(flightDTO);
		int flightid=adminService.addFlightDetails(flightDTO, fareId, flightInfoId, inventoryId);
		return ResponseEntity.status(HttpStatus.CREATED).body("Flight id is "+flightid);
		
	}
	
	//get the AirlineInformation details by using id
	@GetMapping("/getAirlineInfo/{airlineId}")
	public ResponseEntity<AirlineDTO> getAirlineDetailsById(@PathVariable("airlineId") int airlineId)
	{
		if (adminService.getByAirlineId(airlineId)!=null)
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getByAirlineId(airlineId));
		} 
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}	
	}
	
	//delete the airlineInformation by using id 
	@DeleteMapping("/deleteAirlineInfo/{airlineId}")
	public ResponseEntity<String> deleteByAirlineId(@PathVariable("airlineId") int airlineId)
	{
		if (adminService.deleteByAirlineId(airlineId))
		{
			return ResponseEntity.ok("Airline info deleted successfully !!!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no Airline info record deleted ");
		}		
	}
	
	//delete the flightInfo data from database by using id
	@DeleteMapping("/deleteFlightInfo/{flightInfoId}")
	public ResponseEntity<String> deleteByFlightInfoId(@PathVariable("flightInfoId") int flightInfoId)
	{
		if (adminService.deleteByFlightInfoId(flightInfoId))
		{
			return ResponseEntity.ok("FlightInfo deleted successfully !!!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No flightInfo record deleted");
		}
		
	}
	
	//update AirlineInformation_ airlineName by using id
	@PutMapping("/updateAirlineName/{airlineId}/{airlineName}")
	public ResponseEntity<String> updateAirlineNameByUsingId(@PathVariable("airlineId") int airlineId,
															 @PathVariable("airlineName") String airlineName)
	{
		if (adminService.updateAirlineNameByUsingId(airlineId, airlineName)!=null) 
		{
			return ResponseEntity.ok("airlineName updated successfully !");
		} 
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No Airline  record updated ");
		}
				
	}
	
	//update FlightInfo_airlineType by using Id
	@PutMapping("/updateFlightInfoType/{flightInfoId}/{flightInfoType}")
	public ResponseEntity<String> updateFlightInfoTypeByUsingFlightInfoId(@PathVariable("flightInfoId") int flightInfoId,
																		 @PathVariable("flightInfoType") String flightInfoType)
	{
		
		if (adminService.updateFlightInfoTypeByUsingId(flightInfoId, flightInfoType) != null )
		{
			return ResponseEntity.ok("Flight Info type updated successfully !");	
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No flightInfo type  record updated ");
		}		
	}

	//getAll flights details
	@GetMapping("/getAllFlightDetails")
	public  List<FlightDTO> getAllFlightsDetails()
	{
		return  adminService.getAllFlights();
	}

	//get flight by using flightNumber
	@GetMapping("/getAllFlightDetails/{flightNumber}")
	public List<FlightDTO> searchByFlightNumber(@PathVariable("flightNumber") String flightNumber)
	{
		
		return adminService.searchByFlightNumber(flightNumber);
		
	}
	
	// get flight search by current city and destination And Date
	@GetMapping("/getFlightDetailsByLocDestinyDate")
	public List<FlightDTO> searchBycurrentLocationAndDestinationAndDate(@RequestBody FlightDTO flightDTO)
	{
		return adminService.searchBycurrentLocationAndDestinationAndDate(flightDTO);
		
	}

	
}

