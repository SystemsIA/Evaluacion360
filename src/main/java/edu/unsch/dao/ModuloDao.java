package edu.unsch.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unsch.entities.Modulo;

public interface ModuloDao extends JpaRepository<Modulo, Serializable> {
}
