package com.sibs.app.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sibs.app.dtos.BancoDTO;
import com.sibs.app.services.BancoService;

@RestController
@RequestMapping(value = "/bancos")
public class BancoResource {
	
	private BancoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BancoDTO> findById(@PathVariable Long id){
		BancoDTO objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}