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
@Table(name ="check_in_table")
public class CheckIn 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkInId;
	private int seatNumber;
	private int gateNumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "checkIn")
	private List<Passenger> passenger;
}


//one check_in can check multiple passengers @OneToMany
//@JoinColumn(name = "passenger_Id")
