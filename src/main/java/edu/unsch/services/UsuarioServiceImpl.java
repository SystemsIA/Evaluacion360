package edu.unsch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unsch.dao.UsuarioDao;
import edu.unsch.entities.Usuario;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao repository;
	
	@Override
	public Usuario login(String usuario, String password) {
		return repository.login(usuario, password);
	}

	@Override
	public Usuario loginAdmin(String usuario, String password) {
		return repository.loginAdmin(usuario, password);
	}
	
}
