package org.indigo.airlines.dto;

import org.indigo.airlines.entity.BookingInformation;
import org.indigo.airlines.entity.CheckIn;
import org.indigo.airlines.entity.Passenger;

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
public class PassengerDTO 
{

	private String emailId;
	private String firstName;
	private String lastName;
	private String gender;
	private long mobileNumber;
	
}
