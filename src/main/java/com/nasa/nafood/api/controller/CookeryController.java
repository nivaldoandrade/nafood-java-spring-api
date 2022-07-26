package com.nasa.nafood.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.api.model.CookeryXmlWrapper;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.service.cookery.CreateCookeryService;
import com.nasa.nafood.domain.service.cookery.DeleteCookeryService;
import com.nasa.nafood.domain.service.cookery.FindByNameCookeryService;
import com.nasa.nafood.domain.service.cookery.ListCookeryService;
import com.nasa.nafood.domain.service.cookery.ShowCookeryService;
import com.nasa.nafood.domain.service.cookery.UpdateCookeryService;

@RestController
@RequestMapping(value = "/cookeries") //, produces = MediaType.APPLICATION_XML_VALUE)
public class CookeryController {

	private ListCookeryService listCookeryService;
	private ShowCookeryService showCookeryService;
	private FindByNameCookeryService findByNameCookeryService;
	private UpdateCookeryService updateCookeryService;
	private CreateCookeryService createCookeryService;
	private DeleteCookeryService deleteCookeryService;
	
	public CookeryController(
			ListCookeryService listCookeryService,
			ShowCookeryService showCookeryService,
			FindByNameCookeryService findByNameCookeryService,
			UpdateCookeryService updateCookeryService,
			CreateCookeryService createCookeryService,
			DeleteCookeryService deleteCookeryService
	) {
		super();
		this.listCookeryService = listCookeryService;
		this.updateCookeryService = updateCookeryService;
		this.showCookeryService = showCookeryService;
		this.findByNameCookeryService = findByNameCookeryService;
		this.createCookeryService = createCookeryService;
		this.deleteCookeryService = deleteCookeryService;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cookery> index() {
		return listCookeryService.execute();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CookeryXmlWrapper indexXML() {
		return new CookeryXmlWrapper(listCookeryService.execute());
	}
	
	@GetMapping("/{cookeryId}")
	public Cookery show(@PathVariable Long cookeryId) {
		return showCookeryService.execute(cookeryId);
	
	}
	
	@GetMapping("/name")
	public List<Cookery> findByName(@RequestParam("name") String name) {
		return findByNameCookeryService.execute(name);

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cookery store(@RequestBody Cookery cookery) {
		return createCookeryService.execute(cookery);
	}
	
	@PutMapping("/{cookeryId}") 
	public Cookery update(@PathVariable long cookeryId, @RequestBody Cookery cookery) {
		return updateCookeryService.execute(cookeryId, cookery);
		
	}
	
	@DeleteMapping("/{cookeryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long cookeryId) {
			deleteCookeryService.execute(cookeryId);
			
	}
	
//	@DeleteMapping("/{cookeryId}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable long cookeryId) {
//		deleteCookeryService.execute(cookeryId);
//	}
	
}
