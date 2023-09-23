package org.indigo.airlines.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "passenger_table")
public class Passenger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String emailId;
	private String firstName;
	private String lastName;
	private String gender;
	private long mobileNumber;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="bookingId")
	private BookingInformation bookingInformation;//foreign key
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "checkInId")
	private CheckIn checkIn;//foreign key
}


//many passenger having one booking's
//here i use LAZY for fetching purpose if use multiple eager fetchtype at that time it could not load multiple bags"collections" at a time 
//antea ikkada mapped name same entity class name undali  and diniki opposite entity lo @joinCloumn undali anthea 
//multiple passenger having one  check_in's