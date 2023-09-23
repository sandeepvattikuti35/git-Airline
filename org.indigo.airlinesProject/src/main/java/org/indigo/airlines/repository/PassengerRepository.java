package org.indigo.airlines.repository;

import org.indigo.airlines.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>
{

}
