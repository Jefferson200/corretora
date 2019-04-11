package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.banco.Repository.UsuarioRepository;
import com.banco.models.Conta;
import com.banco.models.Usuario;


@Controller
public class IndexController {
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String cadastrarCliente() {
		return "cadastro/cadastroCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String cadastrarCliente(Usuario usuario) {
		System.out.println(usuario.getData());
		
		usuarioRepository.save(usuario);
		
		
		return "redirect: /conta";
		
	}
	
	@RequestMapping(value="/cadastrarConta", method=RequestMethod.GET)
	public String cadastrarConta() {
		return "CadastroConta";
	}
	
	@RequestMapping(value="/cadastrarConta", method=RequestMethod.POST)
	public String cadastrarConta(Conta conta) {
		return "CadastroConta";
	}
	
	@RequestMapping(value="sobre", method=RequestMethod.GET)
	public String sobre() {
		return "about";
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
