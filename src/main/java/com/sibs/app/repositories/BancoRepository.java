package com.sibs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sibs.app.entities.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long>{

}
