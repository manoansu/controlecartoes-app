package com.sibs.app.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.sibs.app.entities.Banco;

public class BancoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String number;

	private Instant date;

	public BancoDTO() {
	}

	public BancoDTO(Long id, String name, String number, Instant date) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.date = date;
	}

	public BancoDTO(Banco banco) {
		id = banco.getId();
		name = banco.getName();
		number = banco.getNumber();
		date = banco.getDate();
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

	public Instant getDate() {
		return date;
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

	public void setDate(Instant date) {
		this.date = date;
	}

}
