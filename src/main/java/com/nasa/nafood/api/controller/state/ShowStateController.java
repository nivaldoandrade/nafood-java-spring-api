package com.nasa.nafood.api.controller.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.service.state.ShowStateService;

@RestController
@RequestMapping("/states/{stateId}")
public class ShowStateController {
	
	@Autowired
	private ShowStateService showStateService;
	
	@GetMapping
	public State show(@PathVariable long stateId) {
		return showStateService.execute(stateId);

	}
}
