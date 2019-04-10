package com.banco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banco.Repository.UsuarioRepository;
import com.banco.models.Usuario;

@Controller
public class IndexController {
	
	UsuarioRepository usuarioRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Usuario usuario) {
		if(usuarioRepository.findByEmail(usuario.getEmail()) != null){
			Usuario u= usuarioRepository.findByEmail(usuario.getEmail());
			if(u.getSenha()==usuario.getSenha()) {
				return "redirect:/home";
			}
		
		return "redirect:/";
		}
		return "redirect:/";
	}
	
}
