package com.sistema.clinica.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.clinica.app.models.dao.UsuarioDAO;
import com.sistema.clinica.app.models.entity.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioDAOImpl")
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("/usuarios")
	public String lista(Model model) {
		
		Usuario user = new Usuario();
		
		user = usuarioDAO.getUsuarios();
		
		model.addAttribute("titulo", "Usarios");
		model.addAttribute("user", user);
		
		return "usuarios";
	}
	
	@RequestMapping("/login")
	public String mostrar(Model model) {
		
			
		return "login";
	}


}
