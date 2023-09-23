package org.indigo.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_table")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String gender;
	private String userName;
	private int password;
}
