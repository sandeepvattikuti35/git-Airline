package org.indigo.airlines.adminService;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.indigo.airlines.dto.AirlineDTO;
import org.indigo.airlines.dto.BookingInfoDTO;
import org.indigo.airlines.dto.CheckInDTO;
import org.indigo.airlines.dto.FareDTO;
import org.indigo.airlines.dto.FlightDTO;
import org.indigo.airlines.dto.FlightInfoDTO;
import org.indigo.airlines.dto.InventoryDTO;
import org.indigo.airlines.dto.PassengerDTO;
import org.indigo.airlines.dto.UserDTO;
import org.indigo.airlines.entity.AirlineInformation;
import org.indigo.airlines.entity.BookingInformation;
import org.indigo.airlines.entity.CheckIn;
import org.indigo.airlines.entity.Fare;
import org.indigo.airlines.entity.Flight;
import org.indigo.airlines.entity.FlightInfo;
import org.indigo.airlines.entity.Inventory;
import org.indigo.airlines.entity.Passenger;
import org.indigo.airlines.entity.User;
import org.indigo.airlines.repository.AirlineRepository;
import org.indigo.airlines.repository.BookingInfoRepository;
import org.indigo.airlines.repository.CheckInRepository;
import org.indigo.airlines.repository.FareRepository;
import org.indigo.airlines.repository.FlightInfoRepository;
import org.indigo.airlines.repository.FlightRepository;
import org.indigo.airlines.repository.InventoryRepostiory;
import org.indigo.airlines.repository.PassengerRepository;
import org.indigo.airlines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService
{
	
	//adding airline information data into data base
	@Autowired
	private  AirlineRepository airlineRepository;
	@Override
	public int addAirlineInformation(AirlineDTO airlineDTO) 
	{
		AirlineInformation airlineInformation = airlineRepository
												.save(AirlineInformation.builder()
																		.airlineName(airlineDTO.getAirlineName())
																		.build());
		System.out.println(airlineInformation);
		return airlineInformation.getAirlineID();
	}
	
	//adding flight info data into database
	@Autowired
	private FlightInfoRepository flightInfoRepository;
	@Autowired
	private AirlineRepository airlineRepository2;
	@Override
	public int addFlightInfo(FlightInfoDTO flightInfoDTO, int airlineId)
	{
	
		//stream api will be used in collection only so here i taken airlineId within the method 
		AirlineInformation airlineInformation = airlineRepository2.findById(airlineId).get();
										//.orElseThrow(()-> new NotFoundException());
		
		//to get object of flightInfo and to transfer data from flightInfoDTO to flightInfo
		 FlightInfo flightInfos = FlightInfo.builder()
												 .flightInfoNumber(flightInfoDTO.getFlightInfoNumber())
												 .flightInfoTime(flightInfoDTO.getFlightInfoTime())// You might want to use the provided time from the DTO
												 .flightInfoType(flightInfoDTO.getFlightInfoType())
												 .airlineInformation(airlineInformation)// Establish the relationship
												 .build();
		System.out.println(flightInfos);
		return flightInfoRepository.save(flightInfos).getFlightInfoId();// Return the ID of the added flight info
	}

	//adding fare data into 
	@Autowired
	private FareRepository fareRepository;
	@Override
	public int addFareDetails(FareDTO fareDTO)
	{
		Fare fare = fareRepository.save(Fare.builder()
											.currency(fareDTO.getCurrency())
											.amount(fareDTO.getAmount())
											 .build());
		System.out.println(fare);
		return fare.getFareID();
	}
	
	//adding inventory data into database
	@Autowired
	private InventoryRepostiory inventoryRepostiory;
	@Override
	public int addInventoryDetails(InventoryDTO inventoryDTO)
	{
		Inventory inventory = inventoryRepostiory.save(Inventory.builder()
																.count(inventoryDTO.getCount())
																.build());
		System.out.println(inventory);
		return inventory.getInventoryId();
	}
	
	//adding flight data into database
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private FareRepository fareRepository2;
	@Autowired
	private FlightInfoRepository flightInfoRepository2;
	@Autowired
	private InventoryRepostiory inventoryRepostiory2;
	@Override
	public int addFlightDetails(FlightDTO flightDTO, int fareId, int flightInfoId, int inventoryId)
	{
		//first get foreign key id's from data base 
		Fare fareid = fareRepository2.findById(fareId).get(); // getting fareid 
		
		FlightInfo flightInfoid= flightInfoRepository2.findById(flightInfoId).get(); //getting flightInfoid
		
		Inventory inventoryid= inventoryRepostiory2.findById(inventoryId).get(); //getting inventoryid
		
		//to get flight object and to transfer the data from flightDTO to flight
		Flight flight = flightRepository.save(Flight.builder()
							  .flightDestination(flightDTO.getFlightDestination())
							  .flightDate(flightDTO.getFlightDate())
							  .flightNumber(flightDTO.getFlightNumber())
							  .flightTime(flightDTO.getFlightTime())
							  .flightCurrentLocation(flightDTO.getFlightCurrentLocation())
							  .fare(fareid)					// Establish the relationship
							  .flightInfo(flightInfoid)		// Establish the relationship
							  .inventory(inventoryid)		// Establish the relationship
							  .build());
		
		System.out.println(flight);
		return flightRepository.save(flight).getFlightId();
	}
	
	//adding booking information into database
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	@Override
	public int addBookingInformation(BookingInfoDTO bookingInfoDTO)
	{
		//to get booking information object to transfer the data from bookingInfoDTO to bookingInformation 
		BookingInformation bookingInformation= bookingInfoRepository
												.save(BookingInformation.builder()
																		.bookingDate(bookingInfoDTO.getBookingDate())
																		.destination(bookingInfoDTO.getDestination())
																		.fare(bookingInfoDTO.getFare())
																		.flightDate(bookingInfoDTO.getFlightDate())
																		.flightNumber(bookingInfoDTO.getFlightNumber())
																		.status(bookingInfoDTO.getStatus())
																		.flightTime(bookingInfoDTO.getFlightTime())
																		.currentCity(bookingInfoDTO.getCurrentCity())
																		.build());
		System.out.println(bookingInformation);
		return bookingInformation.getBookingId();
	}
	
	//adding checkIn data into database
	@Autowired
	private CheckInRepository checkInRepository;
	@Override
	public int addCheckInDetails(CheckInDTO checkInDTO) 
	{
		//to get checkIn object to transfer the data from checkInDTO to checkIn
		CheckIn checkIn = checkInRepository.save(CheckIn.builder()
														.seatNumber(checkInDTO.getSeatNumber())
														.gateNumber(checkInDTO.getGateNumber())
														.build());
		System.out.println(checkIn);
		return checkIn.getCheckInId();
	}

	//adding passenger data into database
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private BookingInfoRepository bookingInfoRepository2;
	@Autowired
	private CheckInRepository checkInRepository2;
	@Override
	public int addPassengerDetails(PassengerDTO passengerDTO,int bookingId,int checkInId) 
	{
		//first get foreign key id's from data base 
		BookingInformation information=bookingInfoRepository2.findById(bookingId).get();
		CheckIn checkIn=checkInRepository2.findById(checkInId).get();
		Passenger passenger = passengerRepository.save(Passenger.builder()
																.emailId(passengerDTO.getEmailId())
																.firstName(passengerDTO.getFirstName())
																.lastName(passengerDTO.getLastName())
																.gender(passengerDTO.getGender())
																.mobileNumber(passengerDTO.getMobileNumber())
																.bookingInformation(information)
																.checkIn(checkIn)
																.build());
		System.out.println(passenger);
		return passenger.getPassengerId();
	}

	//adding user data into database
	@Autowired
	private UserRepository userRepository;	
	@Override
	public int addUser(UserDTO userDTO)
	{
		User user= userRepository.save(User.builder()
										 .firstName(userDTO.getFirstName())
										 .lastName(userDTO.getLastName())
										 .mobileNumber(userDTO.getMobileNumber())
										 .gender(userDTO.getGender())
										 .userName(userDTO.getUserName())
										 .password(userDTO.getPassword())
										 .build());
		System.out.println(user);
		return user.getUserid();
	}
	//getting booking details by using find by bookingId
	@Override
	public BookingInfoDTO findByBookingDetailsById(int bookingid)
	{
		Optional<BookingInformation> optional= bookingInfoRepository.findById(bookingid);
		if (optional.isPresent())
		{
			BookingInformation bi= optional.get();//to get book entity object
			 //Transfer data from bookingInformation to bookingInformationDto
			BookingInfoDTO infoDTO=BookingInfoDTO.builder()
											 	.bookingDate(bi.getBookingDate())
											 	.destination(bi.getDestination())
											 	.fare(bi.getFare())
											 	.flightDate(bi.getFlightDate())
											 	.flightNumber(bi.getFlightNumber())
											 	.status(bi.getStatus())
											 	.flightTime(bi.getFlightTime())
											 	.currentCity(bi.getCurrentCity())
											    .build();
			return infoDTO;
		}
		else
		{
		return null;
		}
	}
	//getting bookingInfo details by using getAll() method
	@Override
	public List<BookingInfoDTO> getAllBookingInfoDTOs() 
	{
		List<BookingInformation> optional=bookingInfoRepository.findAll();
		
		if (optional.size()>0)
		{
			//transfer List of bookingInfo to list of bookingInfoDTO
			List<BookingInfoDTO> dtos = optional.stream()
												.map(t-> BookingInfoDTO.builder()
																		.bookingDate(t.getBookingDate())
																		.destination(t.getDestination())
																		.fare(t.getFare())
																		.flightDate(t.getFlightDate())
																		.flightNumber(t.getFlightNumber())
																		.status(t.getStatus())
																		.flightTime(t.getFlightTime())
																		.currentCity(t.getCurrentCity())
																		.build())
												.collect(Collectors.toList());
			return dtos;
		}
		else
		{
			return null;	
		}
		
		
		
	}
	//getting AirlineInformation by using Id
	@Override
	public AirlineDTO getByAirlineId(int airlineId)
	{
		Optional<AirlineInformation> optional=airlineRepository.findById(airlineId);
		if (optional.isPresent())
		{
			AirlineInformation ai=optional.get();//to get book entity object
			 //Transfer data from AirlineInformation to AirlineInformationDTO
			AirlineDTO airlineDTO=AirlineDTO.builder()
											.airlineName(ai.getAirlineName())
										     .build();
			return airlineDTO;
		}
		else
		{
			return null;	
		}
	}
	//delete AirlineInformation by using Id
	//@Transactional
	@Override
	public boolean deleteByAirlineId(int airlineId)
	{
		//try
		//{			 
			//flightInfoRepository.deleteByAirlineInformation_AirlineId(airlineID);
			airlineRepository.deleteById(airlineId);
			flightInfoRepository.deleteById(airlineId);
			
			  return true;

		//} 
		//catch (Exception e) 
		//{
			// TODO: handle exception
		//	  return false;

		//}
	}
	//delete FlightInfo by using id
	@Override
	public boolean deleteByFlightInfoId(int flightInfoId)
	{
		flightInfoRepository.deleteById(flightInfoId);
		flightRepository.deleteById(flightInfoId);
		return true;
	}
	

	//login user
	@Override
	public UserDTO userLogIn(String userName, int password) 
	{
		User user= userRepository.logInUser(userName, password);
		if (user!=null)
		{
			UserDTO userDTO= UserDTO.builder()
						  .firstName(user.getFirstName())
						  .lastName(user.getLastName())
						  .build();
			return userDTO;
		} 
		else 
		{
			return null;
		}
	}
	//update AirlineInformation_ airlineName by using id
	@Override
	public AirlineDTO updateAirlineNameByUsingId(int airlineId, String airlineName)
	{
		AirlineInformation airlineInformation=airlineRepository.findById(airlineId).get();
		airlineInformation.setAirlineName(airlineName);//here updated name data will be insert to here what we enter in api
		AirlineDTO airlineDTO=AirlineDTO.builder()
										.airlineName(airlineInformation.getAirlineName())
										.build();
		airlineRepository.save(airlineInformation);
		return airlineDTO;
	}
	//update FlightInfo_airlineType by using Id
	@Override
	public FlightInfoDTO updateFlightInfoTypeByUsingId(int flightInfoId, String flightInfoType)
	{
		FlightInfo flightInfo = flightInfoRepository.findById(flightInfoId).get();
		flightInfo.setFlightInfoType(flightInfoType);//here updated type data will be insert to here what we enter in api
		FlightInfoDTO flightInfoDTO = FlightInfoDTO.builder()
													.flightInfoType(flightInfo.getFlightInfoType())
													.build();
		flightInfoRepository.save(flightInfo);
		return flightInfoDTO;
	}
	
	//get all Flights by using get All method()
	@Override
	public List<FlightDTO> getAllFlights() 
	{
		return flightRepository.findAll().stream()
				.map(t -> FlightDTO.builder() //t- represents FlightDatabase
						.flightCurrentLocation(t.getFlightCurrentLocation())
						.flightDate(t.getFlightDate())
						.flightDestination(t.getFlightDestination())
						.flightNumber(t.getFlightNumber())
						.flightTime(t.getFlightTime())
						.fareDTO(FareDTO.builder()
										.amount(t.getFare().getAmount())
										.currency(t.getFare().getCurrency())
										.build())
						.inventoryDTO(InventoryDTO.builder()
												  .count(t.getInventory().getCount())
												  .build())
						.build())
				.collect(Collectors.toList());
		
	}
	//instead of repeating above code mam simply used stream() method in that filter method was used
	//searching flight by using FlightNumber
	@Override
	public List<FlightDTO> searchByFlightNumber(String flightNumber)
	{
		return getAllFlights().stream()
							  .filter(t -> t.getFlightNumber().equals(flightNumber)) //t - represents flight Entity
							  .collect(Collectors.toList());
	}

	// get flight search by current city and destination And Date
	@Override
	public List<FlightDTO> searchBycurrentLocationAndDestinationAndDate(FlightDTO flightDTO) 
	{
		return getAllFlights().stream()
								.filter(t-> t.getFlightCurrentLocation().equals(flightDTO.getFlightCurrentLocation()) &&
											t.getFlightDestination().equals(flightDTO.getFlightDestination())&&
											t.getFlightDate().equals(flightDTO.getFlightDate()))
								
								.collect(Collectors.toList());
	}

	

	

	

	
	

}
