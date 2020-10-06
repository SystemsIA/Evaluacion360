package edu.unsch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unsch.dao.PerfilDao;
import edu.unsch.dao.UsuarioDao;
import edu.unsch.dao.UsuarioPerfilDao;
import edu.unsch.entities.Usuario;
import edu.unsch.entities.UsuarioPerfil;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PerfilDao perfilDao;

	@Autowired
	private UsuarioPerfilDao usuarioPerfilDao;

	@Override
	public Usuario login(String usuario, String password) {
		return usuarioDao.login(usuario, password);
	}

	@Override
	public Usuario loginAdmin(String usuario, String password) {
		return usuarioDao.loginAdmin(usuario, password);
	}

	@Override
	public void registrarVendedor(String nombre, String usuario, String password) {
		Usuario vendedor = new Usuario();
		vendedor.setNombre(nombre);
		vendedor.setPassword(password);
		vendedor.setUsuario(usuario);

		usuarioDao.save(vendedor);
		usuarioPerfilDao.save(new UsuarioPerfil(perfilDao.perfilVendedor(), vendedor));
	}

	@Override
	public void registrarComprador(String nombre, String usuario, String password) {
		Usuario comprador = new Usuario();
		comprador.setNombre(nombre);
		comprador.setPassword(password);
		comprador.setUsuario(usuario);

		usuarioDao.save(comprador);
		usuarioPerfilDao.save(new UsuarioPerfil(perfilDao.perfilComprador(), comprador));
	}

}
