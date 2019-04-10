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
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String cadastrarCliente() {
		return "cadastro/cadastroCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String cadastrarCliente(Usuario usuario) {
		Usuario u= new Usuario();
		u.setCpf(usuario.getCpf());
		u.setDataNasc(usuario.getDataNasc());
		u.setEmail(usuario.getEmail());
		u.setNome(usuario.getNome());
		u.setSenha(usuario.getSenha());
		u.setTelefone(u.getTelefone());
		u.setTipo(usuario.getTipo());
		usuarioRepository.save(u);
		return "redirect:/";
		
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
