package br.com.system.crud.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.system.crud.library.model.entity.Prateleira;

@Repository
public interface PrateleiraRepository extends JpaRepository<Prateleira, Long>{}
