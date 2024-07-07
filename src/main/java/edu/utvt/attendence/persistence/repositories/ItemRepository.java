package edu.utvt.attendence.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.attendence.persistence.entities.Item;
import edu.utvt.attendence.persistence.entities.Persona;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
