package org.indigo.airlines.dto;

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
public class UserDTO 
{
	
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String gender;
	private String userName;
	private int password;
}
