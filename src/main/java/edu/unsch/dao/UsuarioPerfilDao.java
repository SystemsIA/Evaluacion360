package edu.unsch.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unsch.entities.UsuarioPerfil;

@Repository
public interface UsuarioPerfilDao extends JpaRepository<UsuarioPerfil, Serializable>{
	
}
