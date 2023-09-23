package org.indigo.airlines.repository;

import org.indigo.airlines.entity.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer>
{
	//delete flight info based  on airlineId
	//boolean deleteByAirlineInformation_AirlineId(int airlineId);

	//void deleteByAirlineInformation_AirlineId(int airlineID);
}
