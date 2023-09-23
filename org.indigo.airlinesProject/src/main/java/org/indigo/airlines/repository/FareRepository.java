package org.indigo.airlines.repository;

import org.indigo.airlines.entity.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Integer>
{

}
