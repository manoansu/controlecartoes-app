package com.sibs.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sibs.app.dtos.BancoDTO;
import com.sibs.app.entities.Banco;
import com.sibs.app.repositories.BancoRepository;
import com.sibs.app.services.exception.ObjectNotFoundException;

@Service
public class BancoService {

	private BancoRepository repository;

	@Transactional(readOnly = true)
	public BancoDTO findById(Long id) {
		Optional<Banco> objId = repository.findById(id);
		Banco obj = objId.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Banco.class.getName()));
		return new BancoDTO(obj);
	}

	@Transactional(readOnly = true)
	public Page<BancoDTO> findAllPerPage(Pageable pageable) {
		Page<Banco> list = repository.findAll(pageable);
		return list.map(dto -> new BancoDTO(dto));
	}
}
