package edu.unsch.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.unsch.entities.Usuario;

@Repository("usuarioDao")
public interface UsuarioDao extends JpaRepository<Usuario, Serializable> {

//	Usuario findByUsuarioAndPassword(String usuario, String password);

	@Query(value = "select u from Usuario u where u.usuario = ?1 and u.password = ?2")
	Usuario login(String usuario, String password);
	
	@Query(value = "select * from usuario u left join usuario_perfil up on up.idusuario=u.idusuario where up.idperfil=1 and u.usuario = ?1 and u.password = ?2", nativeQuery = true)
	Usuario loginAdmin(String usuario, String password);
}
