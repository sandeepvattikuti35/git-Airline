package org.indigo.airlines.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "airline_information_table")
public class AirlineInformation
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airlineID;
	private String airlineName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "airlineInformation")
	private	 List<FlightInfo> flightInfo; 
}

//@JoinColumn(name = "flight_Info_Id")
//one airline having multiple  flights 
//fetch chesthea flightInfo details airlines information dantlo ravali
