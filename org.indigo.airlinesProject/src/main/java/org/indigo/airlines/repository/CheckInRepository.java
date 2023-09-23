package org.indigo.airlines.repository;

import org.indigo.airlines.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer>
{

}
