package com.sibs.app.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numero;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "banco_id")
	private Banco banco;

	public Cartao() {
	}

	public Cartao(Long id, String numero, Instant date, Banco banco) {
		this.id = id;
		this.numero = numero;
		this.banco = banco;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(id, other.id);
	}

}
