package org.indigo.airlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.indigo.airlines.entity.Fare;
import org.indigo.airlines.entity.FlightInfo;
import org.indigo.airlines.entity.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class FlightDTO 
{
	private String flightDestination;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String flightCurrentLocation;
	
	private FareDTO fareDTO;
	private InventoryDTO inventoryDTO;
}
