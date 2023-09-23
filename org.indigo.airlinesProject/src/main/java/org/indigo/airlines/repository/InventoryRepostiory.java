package org.indigo.airlines.repository;

import org.indigo.airlines.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepostiory extends JpaRepository<Inventory, Integer>
{

}
