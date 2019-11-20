package com.capgemini.projectFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.projectFinal.model.Profesor;

public interface ProfeRepository extends CrudRepository<Profesor,Integer>{
	List<Profesor> findByMail(String mail);
}
