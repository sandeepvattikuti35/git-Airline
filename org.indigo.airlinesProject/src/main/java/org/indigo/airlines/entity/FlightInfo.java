package org.indigo.airlines.entity;

import java.time.LocalTime;
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
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "flight_info_table")
public class FlightInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightInfoId;
	private String flightInfoNumber;
	private LocalTime flightInfoTime;
	private String flightInfoType;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_Id")//,referencedColumnName = "airlineID"
	private AirlineInformation airlineInformation;//Foreign key

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "flightInfo")
	//@JsonBackReference
	private List<Flight> flight;
	
	
    // Assign the current local time to the flightTime variable

	
}

//how flight info is used
//n large airports, there are different sets of FIDS for each terminal or even each major airline.
//FIDS are used to inform passengers of boarding gates, departure/arrival times, destinations, 
//notifications of flight delays/flight cancellations, and partner airlines, et al.

//flight info means
//You can search for flight schedules and delays and track flight information in real-time via 
//your airline's website. Simply enter your flight number, and you should find what you want.
//You can also use flight tracker applications and websites as well.

//@ManyToMany flights are related one  airline 
//antea ikkada mapped name same entity class name undali  and diniki opposite entity lo @joinCloumn undali anthea 
//one flight info undi but okadani data nea isthundi okasariki 
//@JoinColumn(name = "flight_Id")
	//@BatchSize(size = 10)

