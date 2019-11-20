package com.capgemini.projectFinal;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.projectFinal.model.Curso;
import com.capgemini.projectFinal.model.Profesor;
import com.capgemini.projectFinal.model.Tema;
import com.capgemini.projectFinal.repository.CursoRepository;
import com.capgemini.projectFinal.repository.ProfeRepository;
import com.capgemini.projectFinal.repository.TemaRepository;

@SpringBootApplication
public class ProjectFinalApplication {

	private static final Logger log = LoggerFactory.getLogger(ProjectFinalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectFinalApplication.class, args);

	}

	@Bean
	public CommandLineRunner demoProfe(ProfeRepository repoProfe, CursoRepository repoCurso, TemaRepository repoTema) {
		return (args) -> {
			// save a few profesores
			repoProfe.save(new Profesor("David", "Zucbriggen", "david@gmail.com", "123"));
			repoProfe.save(new Profesor("Patricio", "Garino", "pato@gmail.com", "321"));

			// fetch all profesores
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Profesor profe : repoProfe.findAll()) {
				log.info(profe.toString());
			}
			log.info("");

			log.info("");
			// Instancia de objetos.
			Curso back = new Curso("BACK-END");
			Curso front = new Curso("FRONT-END");
			Tema tema1 = new Tema("INTRODUCCION A JAVA");
			Tema tema2 = new Tema("JPA + HIBERNATE");
			Tema tema3 = new Tema("SPRING BOOT");
			Tema tema4 = new Tema("HTML +  CSS");
			Tema tema5 = new Tema("INTRODUCCION A JAVASCRIPT");
			Tema tema6 = new Tema("JQUERY");
			// Instacia de listado de temas
			List<Tema> backTemario = new ArrayList<Tema>();
			List<Tema> frontTemario = new ArrayList<Tema>();
			// Se adieren los cursos correspondientes a sus temas
			tema1.setCurso(back);
			tema2.setCurso(back);
			tema3.setCurso(back);
			tema4.setCurso(front);
			tema5.setCurso(front);
			tema6.setCurso(front);
			// Se adieren los temas al listado de su respectivo curso
			backTemario.add(tema1);
			backTemario.add(tema2);
			backTemario.add(tema3);
			frontTemario.add(tema4);
			frontTemario.add(tema5);
			frontTemario.add(tema6);
			// Se setean los temas en los cursos
			back.setTemas(backTemario);
			front.setTemas(frontTemario);
			// Se persisten los datos de temas.
			repoTema.save(tema1);
			repoTema.save(tema2);
			repoTema.save(tema3);
			repoTema.save(tema4);
			repoTema.save(tema5);
			repoTema.save(tema6);
			// Se persisten los datos de cursos.
			repoCurso.save(back);
			repoCurso.save(front);

			// fetch all cursos
			log.info("Curso found with findAll():");
			log.info("-------------------------------");
			for (Curso cursito : repoCurso.findAll()) {
				log.info("" + cursito.toString());
			}
			log.info("");

			log.info("");

			// fetch all cursos
			log.info("Curso found with findAll():");
			log.info("-------------------------------");
			for (Tema temita : repoTema.findAll()) {
				log.info("" + temita.toString());
			}
			log.info("");

			log.info("");

		};
	}

}
