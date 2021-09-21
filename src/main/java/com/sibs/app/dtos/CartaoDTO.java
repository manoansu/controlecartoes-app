package com.sibs.app.dtos;

import java.io.Serializable;

import com.sibs.app.entities.Cartao;

public class CartaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String numero;

	public CartaoDTO() {
	}

	public CartaoDTO(Long id, String numero) {
		this.id = id;
		this.numero = numero;
	}

	public CartaoDTO(Cartao cartao) {
		id = cartao.getId();
		numero = cartao.getNumero();
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
