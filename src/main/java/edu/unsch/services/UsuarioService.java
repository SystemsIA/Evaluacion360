package edu.unsch.services;

import edu.unsch.entities.Usuario;

public interface UsuarioService {
	Usuario login(String usuario, String password);

	Usuario loginAdmin(String usuario, String password);
}