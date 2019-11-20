package com.capgemini.projectFinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.projectFinal.model.Curso;
import com.capgemini.projectFinal.model.Tema;
import com.capgemini.projectFinal.repository.TemaRepository;



@Controller
public class CursoController {
   
	private static final Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
	private TemaRepository repoTema;

	
	@GetMapping("/buscarcurso")
    public String greetingForm(Model model) {
		model.addAttribute("tema", new Tema());
		model.addAttribute("curso", new Curso());
        model.addAttribute("listaTemas", repoTema.findAll());
        return "busquedacursos";
    }
	
    

	@PostMapping("/buscarcurso")
    public String greetingSubmit(@ModelAttribute Tema tema, @ModelAttribute Curso curso) {
		
		Tema temaBuscado = tema;
		for(Tema temasVisto: repoTema.findByIdTemas(tema.getIdTemas())) {
			temaBuscado.setCurso(temasVisto.getCurso());
			log.info(temaBuscado.getCurso().getNombre_Curso());
		}
		
		
        return "resulcurso";
    }
}
