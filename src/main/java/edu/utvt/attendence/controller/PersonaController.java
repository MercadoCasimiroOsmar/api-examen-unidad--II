package edu.utvt.attendence.controller;

import java.util.List;
import java.util.UUID;

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
import edu.utvt.attendence.persistence.entities.Persona;
import edu.utvt.attendence.persistence.service.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")

public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/all")
	public List<Persona> get(){
		return this.personaService.getAll();
	}
	
	@GetMapping
	public Page<Persona>getMethodoNombre(@RequestParam(value =  "page",defaultValue = "0" ) Integer page, @RequestParam(value = "size", defaultValue = "50") Integer size) {
		return this.personaService.get(page, size);
		
	}

	@PostMapping
	public ResponseEntity<Persona> save (@RequestBody Persona persona){
		return ResponseEntity.created(null).body(this.personaService.save(persona));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> update(@PathVariable("id") UUID id, @RequestBody Persona persona){
		return ResponseEntity.ok(this.personaService.update(id, persona));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Persona> delete(@PathVariable("id") UUID id){
		return this.personaService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> findById(@PathVariable("id") UUID id){
	    return ResponseEntity.of(this.personaService.findById(id));
	}

}