package com.capgemini.projectFinal.repository;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.projectFinal.model.Curso;


public interface CursoRepository extends CrudRepository<Curso,Integer> {
	List<Curso> findByIdCursos(Integer codigo);
}
