package edu.unsch.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.unsch.entities.Submodulo;

@Repository
public interface SubmoduloDao extends JpaRepository<Submodulo, Serializable>{
	
	@Query(value = "SELECT s "
			+ "FROM PerfilOpcion po "
			+ "LEFT JOIN po.opcion o "
			+ "LEFT JOIN o.submodulo s "
			+ "LEFT JOIN s.modulo m "
			+ "LEFT JOIN po.perfil pe "
			+ "WHERE pe.idperfil = SOME ("
									+ "SELECT p.idperfil "
									+ "FROM Perfil as p "
									+ "LEFT JOIN p.usuarioPerfils up "
									+ "LEFT JOIN up.usuario u "
									+ "WHERE u.usuario = ?1 "
									+ ") "
			+ "GROUP BY s.idsubmodulo")
	List<Submodulo> listaSubmodulos(String usuario);
}
