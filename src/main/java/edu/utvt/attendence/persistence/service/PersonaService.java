package edu.utvt.attendence.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import edu.utvt.attendence.persistence.entities.Persona;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonaService {
	
	public Optional<Persona> findById(UUID id);

	public ResponseEntity<Persona> deleteById(UUID id);


	public List<Persona> getAll();

    //Optional<Persona> findById(Long id); //

  //  ResponseEntity<Persona> deleteById(Long id);//

	public Page<Persona> findAll(Integer page, Integer size);

	public Persona save(Persona persona);

	public Persona update(UUID id, Persona persona);
	
	public Page<Persona> get(Integer page, Integer size);

	public boolean existsById(UUID personaId);

}
