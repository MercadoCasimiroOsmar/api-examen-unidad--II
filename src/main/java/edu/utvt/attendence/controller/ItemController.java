package edu.utvt.attendence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendence.persistence.entities.Item;
import edu.utvt.attendence.persistence.service.ItemService;



@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/All")
	public List<Item> get(){
		return this.itemService.getAll();
	}
	
	@GetMapping
	public Page<Item>findAll(@RequestParam(defaultValue = "1", value = "page") String page, String size){
		return this.itemService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Item>save(@RequestBody Item item){
		return ResponseEntity.created(null).body(this.itemService.save(item));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@PathVariable("id") Long id,@RequestBody Item item){
		return ResponseEntity.ok(this.itemService.update(id, item));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable("id") Long id){
		return ResponseEntity.of(this.itemService.findById(id));
	}
	
	
	   @DeleteMapping("/{id}")
	    public ResponseEntity <Void> deleteItem(@PathVariable("id") Long id) {
		   this.itemService.deleteById(id);
		   return ResponseEntity.noContent().build();
	    }
	}
	
	
