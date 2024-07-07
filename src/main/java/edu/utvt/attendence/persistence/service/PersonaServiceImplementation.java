package edu.utvt.attendence.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendence.persistence.entities.Persona;
import edu.utvt.attendence.persistence.repositories.PersonaRepository;


	@Service
	public class PersonaServiceImplementation implements PersonaService {

		@Autowired
		private PersonaRepository personaRepository;
		
		@Override
		public Persona save(Persona persona) {
			return this.personaRepository.save(persona);
		}

		@Override
		public Persona update(UUID id, Persona persona) {
			Optional<Persona> personaOptional = this.personaRepository.findById(id);
			
			if (personaOptional.isPresent()) {
				Persona existingPersona = personaOptional.get();
				existingPersona.setNombre(persona.getNombre());
				existingPersona.setEdad(persona.getEdad());
				existingPersona.setUniversidad(persona.getUniversidad());
				existingPersona.setCorreo(persona.getCorreo());
				existingPersona.setFechaNacimiento(persona.getFechaNacimiento());
				
				return this.personaRepository.save(existingPersona);
			} else {
				throw new IllegalArgumentException("Persona not found with id: " + id);
			}
		}

		@Override
		public List<Persona> getAll() {
			return this.personaRepository.findAll();
		}

		@Override
		public Optional<Persona> findById(UUID id) {
			return this.personaRepository.findById(id);
		}

		@Override
		public ResponseEntity<Persona> deleteById(UUID id) {
			Optional<Persona> personaOptional = this.personaRepository.findById(id);
			
			if (personaOptional.isPresent()) {
				this.personaRepository.delete(personaOptional.get());
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@Override
		public Page<Persona> get(Integer page, Integer size) {
			PageRequest pageRequest = PageRequest.of(page, size, Sort.by("nombre")); 
			return this.personaRepository.findAll(pageRequest);
		}

		@Override
		public Page<Persona> findAll(Integer page, Integer size) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(UUID personaId) {
			// TODO Auto-generated method stub
			return false;
		}

		}