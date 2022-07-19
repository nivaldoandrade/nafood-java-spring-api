package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.service.state.ShowStateService;

@RestController
@RequestMapping("/states/{stateId}")
public class ShowStateController {
	
	@Autowired
	private ShowStateService showStateService;
	
	@GetMapping
	public ResponseEntity<State> show(@PathVariable long stateId) {
		try {
			State state = showStateService.execute(stateId);
			
			return ResponseEntity.ok(state);
			
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
