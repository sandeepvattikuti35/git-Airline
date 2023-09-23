package org.indigo.airlines.repository;

import org.indigo.airlines.entity.AirlineInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineInformation, Integer>
{

}
