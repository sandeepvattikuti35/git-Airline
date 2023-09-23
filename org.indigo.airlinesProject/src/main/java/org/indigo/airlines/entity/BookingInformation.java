package org.indigo.airlines.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="booking_information_table")
public class BookingInformation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private LocalDate bookingDate;	//system date
	private String destination;
	private double fare;
	private LocalDate flightDate;	//system date
	private String flightNumber;
	private String status;
	private LocalTime flightTime;	
	private String currentCity;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "bookingInformation")
	private List<Passenger> passenger; 
}

//one booking 
//@JoinColumn(name = "passenger_id")
//fetch chesthea passger details booking inforamtion lo ravli 
