package edu.utvt.attendence.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendence.persistence.entities.Item;
import edu.utvt.attendence.persistence.repositories.ItemRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ItemServiceImplementation implements ItemService {

	 @Autowired
	    private ItemRepository itemRepository;

	    @Override
	    public Item save(Item item) {
	        return itemRepository.save(item);
	    }

	    @Override
	    public Item update(Long id, Item item) {
	        Optional<Item> itemOptional = itemRepository.findById(id);

	        if (itemOptional.isPresent()) {
	            Item existingItem = itemOptional.get();
	            existingItem.setNombre(item.getNombre());
	            existingItem.setDescripcion(item.getDescripcion());
	     

	            return itemRepository.save(existingItem);
	        } else {
	            throw new IllegalArgumentException("Item not found with id: " + id);
	        }
	    }

	    @Override
	    public List<Item> getAll() {
	        return itemRepository.findAll();
	    }

	    @Override
	    public Optional<Item> findById(Long id) {
	        return itemRepository.findById(id);
	    }

	    @Override
	    public ResponseEntity<Item> deleteById(Long id) {
	        Optional<Item> itemOptional = itemRepository.findById(id);

	        if (itemOptional.isPresent()) {
	            itemRepository.delete(itemOptional.get());
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @Override
	    public Page<Item> get(String page, String size) {
	        int pageNumber = Integer.parseInt(page);
	        int pageSize = Integer.parseInt(size);
	        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("nombre"));
	        return itemRepository.findAll(pageRequest);
	    }

		@Override
		public Page<Item> findAll(String page, String size) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Item> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(Long itemId) {
			// TODO Auto-generated method stub
			return false;
		}

	}