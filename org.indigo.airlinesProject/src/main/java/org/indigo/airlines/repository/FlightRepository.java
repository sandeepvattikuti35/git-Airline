package org.indigo.airlines.repository;

import java.time.LocalDate;

import org.indigo.airlines.dto.FlightDTO;
import org.indigo.airlines.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Integer>
{
//	@Query("SELECT f1 FROM flight f1 WHERE f1.flightCurrentLocation = : flightCurrentLocation AND "
//			+ "f1.flightDestination = : flightDestination AND f1.flightDate = : flightDate AND "
//			+ "f1.flightNumber = :flightNumber ")
//	FlightDTO getFlightByUsingLocationDestinyFlightDateAndNumber(@Param("flightCurrentLocation") String flightCurrentLocation,
//																 @Param("flightDestination") String flightDestination,
//																 @Param("flightDate") LocalDate flightDate,
//																 @Param("flightNumber") String flightNumber);

}
