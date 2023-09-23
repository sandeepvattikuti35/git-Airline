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
@Table(name="inventory_table")
public class Inventory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inventoryId;
	private int count;
														//lazy
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "inventory")
	//@JsonBackReference
	private List<Flight> flight; 
}


//@JoinColumn(name ="flight_Id")
//@BatchSize(size = 10)
//one investors invest on many flight
//flights ani undi so reference name match avadam ledu so edi isthea set avuthundi antha 
//fetch chesthea fare details flight dantlo ravali
