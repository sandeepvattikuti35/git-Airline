package org.indigo.airlines.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "flight_table")
public class Flight
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String flightDestination;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String flightCurrentLocation;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	@JoinColumn(name = "fareId")
	//@JsonManagedReference
	private Fare fare;//Foreign key
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "flightInfoId")
	//@JsonManagedReference
	private FlightInfo flightInfo;//Foreign key
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "inventoryId")
	//@JsonManagedReference
	private Inventory inventory;//Foreign key
}




//antea ikkada mapped name same entity class name undali  and diniki opposite entity lo @joinCloumn undali anthea 
//fetch type here i use LAZY 
// Change the fetching strategy of one or more collections to lazy loading using the FetchType.LAZY option.
//Lazy loading loads the collection data only when it's explicitly accessed, which can help you avoid fetching multiple bags simultaneously.
	
//flight ki oka cost so @OneToOne
//many flights having one flightsinfo  @ManyToOne
//many flight has one investor so @ManyToOne