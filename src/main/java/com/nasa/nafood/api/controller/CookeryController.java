package com.nasa.nafood.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nafood.api.model.CookeryXmlWrapper;
import com.nasa.nafood.domain.exception.EntityInUseException;
import com.nasa.nafood.domain.exception.EntityNotFoundException;
import com.nasa.nafood.domain.model.Cookery;
import com.nasa.nafood.domain.service.cookery.CreateCookeryService;
import com.nasa.nafood.domain.service.cookery.DeleteCookeryService;
import com.nasa.nafood.domain.service.cookery.ListCookeryService;
import com.nasa.nafood.domain.service.cookery.ShowCookeryService;
import com.nasa.nafood.domain.service.cookery.UpdateCookeryService;

@RestController
@RequestMapping(value = "/cookeries") //, produces = MediaType.APPLICATION_XML_VALUE)
public class CookeryController {

	private ListCookeryService listCookeryService;
	private ShowCookeryService showCookeryService;
	private UpdateCookeryService updateCookeryService;
	private CreateCookeryService createCookeryService;
	private DeleteCookeryService deleteCookeryService;
	
	public CookeryController(
			ListCookeryService listCookeryService,
			ShowCookeryService showCookeryService,
			UpdateCookeryService updateCookeryService,
			CreateCookeryService createCookeryService,
			DeleteCookeryService deleteCookeryService
	) {
		super();
		this.listCookeryService = listCookeryService;
		this.updateCookeryService = updateCookeryService;
		this.showCookeryService = showCookeryService;
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
	public ResponseEntity<Cookery> show(@PathVariable Long cookeryId) {
		try {
			Cookery cookery = showCookeryService.execute(cookeryId);
			
			return ResponseEntity.ok(cookery);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cookery store(@RequestBody Cookery cookery) {
		return createCookeryService.execute(cookery);
	}
	
	@PutMapping("/{cookeryId}") 
	public ResponseEntity<Cookery> update(@PathVariable long cookeryId, @RequestBody Cookery cookery) {
		try {
			Cookery cookeryUpdate = updateCookeryService.execute(cookeryId, cookery);
			
			return ResponseEntity.ok(cookeryUpdate);
		
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{cookeryId}")
	public ResponseEntity<Cookery> delete(@PathVariable long cookeryId) {
		try {
			deleteCookeryService.execute(cookeryId);
			
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			if(e instanceof EntityNotFoundException) {
				return ResponseEntity.notFound().build();
			}
			
			if(e instanceof EntityInUseException) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
			
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
