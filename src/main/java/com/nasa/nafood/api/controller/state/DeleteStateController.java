package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.service.state.DeleteStateService;

@RestController
@RequestMapping("/states/{stateId}")
public class DeleteStateController {

	@Autowired
	private DeleteStateService deleteStateService;
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long stateId) {
		deleteStateService.execute(stateId);
	}
}
