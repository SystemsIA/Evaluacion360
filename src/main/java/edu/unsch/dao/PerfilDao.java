package edu.unsch.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.unsch.entities.Perfil;

@Repository
public interface PerfilDao extends JpaRepository<Perfil, Serializable>{
	
	@Query(value = "SELECT p FROM Perfil p WHERE p.idperfil = 2")
	Perfil perfilVendedor();
	
	@Query(value = "SELECT p FROM Perfil p WHERE p.idperfil = 3")
	Perfil perfilComprador();
}
