package com.sibs.app.dtos;

import java.io.Serializable;

import com.sibs.app.entities.Banco;

public class BancoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String number;

	public BancoDTO() {
	}

	public BancoDTO(Long id, String name, String number) {
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public BancoDTO(Banco banco) {
		id = banco.getId();
		name = banco.getName();
		number = banco.getNumber();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
