package com.sibs.app.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sibs.app.dtos.BancoDTO;
import com.sibs.app.services.BancoService;

@RestController
@RequestMapping(value = "/bancos")
public class BancoResource {

	@Autowired
	private BancoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<BancoDTO> findById(@PathVariable Long id) {
		BancoDTO objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}

	@GetMapping
	public ResponseEntity<Page<BancoDTO>> findAllPerPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<BancoDTO> listDtos = service.findAllPerPage(pageRequest);
		return ResponseEntity.ok().body(listDtos);
	}

	@PostMapping
	public ResponseEntity<BancoDTO> create(@RequestBody BancoDTO bancoDTO) {
		bancoDTO = service.create(bancoDTO);
		URI url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(bancoDTO.getId())
				.toUri();
		return ResponseEntity.created(url).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BancoDTO> update(@PathVariable Long id, @RequestBody BancoDTO bancoDTO){
		bancoDTO = service.update(id, bancoDTO);
		return ResponseEntity.ok().body(bancoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BancoDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
