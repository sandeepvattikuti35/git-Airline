package org.indigo.airlines.repository;

import org.indigo.airlines.entity.BookingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoRepository extends JpaRepository<BookingInformation, Integer>
{

}
