package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.service.state.CreateStateService;

@RestController
@RequestMapping("/states")
public class CreateStateController {
	
	@Autowired
	private CreateStateService createStateService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public State store(@RequestBody State state) {
		return createStateService.execute(state);
	} 
}
