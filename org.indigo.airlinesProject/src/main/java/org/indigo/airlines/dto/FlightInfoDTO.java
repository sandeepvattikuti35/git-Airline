package org.indigo.airlines.dto;

import java.time.LocalTime;

import org.indigo.airlines.entity.AirlineInformation;

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
public class FlightInfoDTO 
{
	
	private String flightInfoNumber;
	private LocalTime flightInfoTime;
	private String flightInfoType;
	
	
}
