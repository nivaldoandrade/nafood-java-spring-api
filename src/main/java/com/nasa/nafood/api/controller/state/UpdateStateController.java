package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.service.state.UpdateStateService;

@RestController
@RequestMapping("/states/{stateId}")
public class UpdateStateController {

	@Autowired
	private UpdateStateService updateStateService;
	
	@PutMapping
	public ResponseEntity<State> update(@PathVariable long stateId, @RequestBody State state) {
		try {
			state = updateStateService.execute(stateId, state);
			
			return ResponseEntity.ok(state);
			
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
