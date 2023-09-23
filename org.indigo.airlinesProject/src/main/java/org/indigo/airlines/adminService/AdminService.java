package org.indigo.airlines.adminService;

import java.time.LocalDate;
import java.util.List;

import org.indigo.airlines.dto.AirlineDTO;
import org.indigo.airlines.dto.BookingInfoDTO;
import org.indigo.airlines.dto.CheckInDTO;
import org.indigo.airlines.dto.FareDTO;
import org.indigo.airlines.dto.FlightDTO;
import org.indigo.airlines.dto.FlightInfoDTO;
import org.indigo.airlines.dto.InventoryDTO;
import org.indigo.airlines.dto.PassengerDTO;
import org.indigo.airlines.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface AdminService 
{
	//add airline information here the method
	int addAirlineInformation(AirlineDTO airlineDTO);
	
	//add flight_info here the method
	int addFlightInfo(FlightInfoDTO flightInfoDTO,int airlineId);
	
	//add fare here the method
	int addFareDetails(FareDTO fareDTO);
	
	//add Inventory here the method
	int addInventoryDetails(InventoryDTO inventoryDTO);
	
	//add Flight here the method
	int addFlightDetails(FlightDTO flightDTO,int fareId,int flightInfoId,int inventoryId);
	
	//add booking information here the method
	int addBookingInformation(BookingInfoDTO bookingInfoDTO);
	
	//add checkInd here the method
	int addCheckInDetails(CheckInDTO checkInDTO);
	
	//add passenger here the method
	int addPassengerDetails(PassengerDTO passengerDTO,int bookingId,int checkInId);
	
	//addUser method
	int addUser(UserDTO dto);
	
	//getting booking details by using id 
	BookingInfoDTO findByBookingDetailsById(int bookingid);
	
	//getting all Booking details by using getAll()method
	List<BookingInfoDTO> getAllBookingInfoDTOs();
	
	//getting AirlineInformation details by using id
	AirlineDTO getByAirlineId(int airlineId);
	
	//delete AirlineInformation by using id
	//@Transactional
	boolean deleteByAirlineId(int airlineId);
	
	/*
	 * By using the @Transactional annotation and handling both deletions within a single transaction,
	 *  you ensure that both actions are either fully completed or fully rolled back in case of an error.
	 */
	
	//delete FlightInfo by using id
	boolean deleteByFlightInfoId(int flightInfoId);
	
	//user login showing if userName and password will match show login successful
	UserDTO userLogIn(String userName, int password);
	
	//update AirlineInformation_ airlineName by using id
	AirlineDTO updateAirlineNameByUsingId(int airlineId,String airlineName);
	
	//update FlightInfo_airlineType by using Id
	FlightInfoDTO updateFlightInfoTypeByUsingId(int flightInfoId, String flightInfoType);
	
	 //getting flight details based on starting location ,destination,flightDate,flightName
//	FlightDTO getFlightByUsingLocationDestinyFlightDateAndNum(String flightCurrentLocation,
//															   String flightDestination,
//															   LocalDate flightDate,
//															   String flightNumber);
	
	//getAll flights details 
	List<FlightDTO> getAllFlights();
	
	//get flight by using flightNumber
	List<FlightDTO> searchByFlightNumber(String flightNumber);
	
	// get flight search by current city and destination And Date
	List<FlightDTO> searchBycurrentLocationAndDestinationAndDate(FlightDTO flightDTO);
}
