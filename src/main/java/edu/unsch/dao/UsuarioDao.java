package edu.unsch.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.unsch.entities.Usuario;

@Repository("usuarioDao")
public interface UsuarioDao extends JpaRepository<Usuario, Serializable> {

//	Usuario findByUsuarioAndPassword(String usuario, String password);

	@Query(value = "SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.password = ?2")
	Usuario login(String usuario, String password);

	@Query(value = "SELECT u FROM Usuario u "
			+ "LEFT JOIN u.usuarioPerfils up "
			+ "LEFT JOIN up.perfil p "
			+ "WHERE p.idperfil = 1 AND u.usuario = ?1 AND u.password = ?2")
	Usuario loginAdmin(String usuario, String password);
}
