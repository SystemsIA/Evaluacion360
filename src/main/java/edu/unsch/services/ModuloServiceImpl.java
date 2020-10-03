package edu.unsch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unsch.dao.ModuloDao;
import edu.unsch.entities.Modulo;

@Service
public class ModuloServiceImpl implements ModuloService {
	
	@Autowired
	private ModuloDao moduloDao;

	@Override
	public List<Modulo> listaModulos(String usuario) {
		// TODO Auto-generated method stub
		return moduloDao.listaModulos(usuario);
	}

}
