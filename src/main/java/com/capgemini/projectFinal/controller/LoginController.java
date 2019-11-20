package com.capgemini.projectFinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.projectFinal.model.Profesor;
import com.capgemini.projectFinal.repository.ProfeRepository;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ProfeRepository repository;
	
    @GetMapping("/inicio")
    public String greetingIndex(Model model) {
    	model.addAttribute("profesor", new Profesor());
    	return "index";
    }
    
      @PostMapping("/inicio")
      public String greetingSubmit(@ModelAttribute Profesor profesor) {
    	  
    	  Profesor profBuscado = null;
    	  for (Profesor profePers : repository.findByMail(profesor.getMail())) {
    		  if(profePers.getMail().equals(profesor.getMail())) {
    			  profBuscado = profePers;
    		  }	  
    	  }
    	  if(profBuscado != null && profBuscado.getPassword().equals(profesor.getPassword())) {
    		  log.info("el usuario a accedido correctamente");
    	  }else {
    		  log.info("usuario y/o contraseña incorrectas");
    	  }
    		  return profBuscado != null && profBuscado.getPassword().equals(profesor.getPassword())? "enlace" : "index";
      }

}
