package com.sibs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sibs.app.entities.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long>{

}
