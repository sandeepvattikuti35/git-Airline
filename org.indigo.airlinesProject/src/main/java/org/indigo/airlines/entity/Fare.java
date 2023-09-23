package org.indigo.airlines.entity;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="fare_id_table")
public class Fare 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fareID;
	private String  currency;
	private double amount;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "fare")
	//@JsonBackReference
	private Flight flight; 
}

//@JoinColumn(name = "flightId")
	//@BatchSize(size = 10)
//fare for only one flight @OneToOne
//fetch chesthea fare details flight dantlo ravali 