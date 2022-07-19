package com.nasa.nafood.api.controller.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.domain.model.State;
import com.nasa.nafood.domain.service.state.ListStateService;

@RestController
@RequestMapping("/states")
public class ListStateController {

	@Autowired
	private ListStateService listStateService;
	
	@GetMapping
	public List<State> index() {
		return listStateService.execute();
	}
}
