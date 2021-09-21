package com.sibs.app.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sibs.app.dtos.BancoDTO;
import com.sibs.app.entities.Banco;
import com.sibs.app.repositories.BancoRepository;
import com.sibs.app.services.exception.ObjectNotFoundException;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repository;

	@Transactional(readOnly = true)
	public BancoDTO findById(Long id) {
		Optional<Banco> objId = repository.findById(id);
		Banco obj = objId.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Banco.class.getName()));
		return new BancoDTO(obj);
	}

	@Transactional(readOnly = true)
	public Page<BancoDTO> findAllPerPage(PageRequest pageRequest) {
		Page<Banco> list = repository.findAll(pageRequest);
		return list.map(dto -> new BancoDTO(dto));
	}

	@Transactional
	public BancoDTO create(BancoDTO bancoDTO) {
		Banco banco = new Banco();
		banco = copyElement(banco, bancoDTO);
		banco = repository.save(banco);
		return new BancoDTO(banco);
	}

	@Transactional
	public BancoDTO update(Long id, BancoDTO bancoDTO) {

		try {
			@SuppressWarnings("deprecation")
			Banco banco = repository.getOne(id);
			banco = copyElement(banco, bancoDTO);
			banco = repository.save(banco);
			return new BancoDTO(banco);
		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Id not found! Id: " + id + ", Type: " + Banco.class.getName());
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Id not found! Id: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new com.sibs.app.services.exception.DataIntegrityViolationException(
					"Bank cannot be deleted! has associated object..");
		}

	}

	private Banco copyElement(Banco banco, BancoDTO bancoDTO) {
		banco.setName(bancoDTO.getName());
		banco.setNumber(bancoDTO.getNumber());
		return banco;
	}

}
