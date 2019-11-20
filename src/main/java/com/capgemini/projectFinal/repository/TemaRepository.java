package com.capgemini.projectFinal.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.capgemini.projectFinal.model.Tema;

public interface TemaRepository extends CrudRepository <Tema,Integer> {
	List<Tema> findByNombre(String nombre);
	List<Tema> findByIdTemas(Integer codigo);
}
