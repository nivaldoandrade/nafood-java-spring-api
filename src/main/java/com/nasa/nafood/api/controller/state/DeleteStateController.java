package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.service.state.DeleteStateService;

@RestController
@RequestMapping("/states/{stateId}")
public class DeleteStateController {

	@Autowired
	private DeleteStateService deleteStateService;
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable long stateId) {
		try {
			deleteStateService.execute(stateId);
			
			return ResponseEntity.noContent().build();
			
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntityInUseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
