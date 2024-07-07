package edu.utvt.attendence.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendence.persistence.entities.Item;
import edu.utvt.attendence.persistence.entities.Persona;

public interface ItemService {

public Item save(Item item);
	
	public Item update(Long id, Item Item);
	
	public List<Item> getAll();
	
	public Optional<Item> findById(Long id);
	
	public ResponseEntity<Item> deleteById(Long id);
	
	public Page<Item> get(String page, String size);
	
	public Page<Item> findAll(String page, String size);
	
	public List<Item> findAll();
	
	public boolean existsById(Long itemId);
}

