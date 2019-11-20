package com.capgemini.projectFinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.projectFinal.model.Alumno;
import com.capgemini.projectFinal.repository.AlumnoRepository;


@Controller
public class AlumnoController {
	private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	private AlumnoRepository repository;
	
    @GetMapping("/altaalumno")
    public String greetingForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumnoform";
    }
    

    @PostMapping("/altaalumno")
    public String greetingSubmit(@ModelAttribute Alumno alumno) {
    	
    	repository.save(alumno);

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Alumno alumnoPers : repository.findAll()) {
			log.info(alumnoPers.toString());
		}
		log.info("");

        return "resultado";
    }

}
