package edu.unsch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unsch.dao.SubmoduloDao;
import edu.unsch.entities.Submodulo;

@Service
public class SubmoduloServiceImpl implements SubmoduloService {
	
	@Autowired
	private SubmoduloDao submoduloDao;
	
	@Override
	public List<Submodulo> listaSubmodulos(String usuario) {
		// TODO Auto-generated method stub
		return submoduloDao.listaSubmodulos(usuario);
	}

}
