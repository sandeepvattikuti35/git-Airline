package org.indigo.airlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class BookingInfoDTO
{

	private LocalDate bookingDate;	//system date
	private String destination;
	private double fare;
	private LocalDate flightDate;	//system date
	private String flightNumber;
	private String status;
	private LocalTime flightTime;	
	private String currentCity;
	
}
