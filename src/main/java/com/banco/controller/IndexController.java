package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.banco.Repository.ContaRepository;
import com.banco.Repository.UsuarioRepository;
import com.banco.models.Conta;
import com.banco.models.Endereco;
import com.banco.models.Usuario;

@Controller
public class IndexController {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ContaRepository contaRepository;

	private String cpf;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String cadastrarCliente() {
		return "cadastro/cadastroCliente";
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String cadastrarCliente(Usuario usuario, Endereco endereco) {
		usuario.setEndereco(endereco);
		usuarioRepository.save(usuario);
		return "redirect:/cadastrarConta";

	}

	@RequestMapping(value = "/cadastrarConta", method = RequestMethod.GET)
	public String cadastrarConta() {
		return "cadastro/CadastroConta";
	}

	@RequestMapping(value = "/cadastrarConta", method = RequestMethod.POST)
	public String cadastrarConta(Conta conta) {
		contaRepository.save(conta);
		return "redirect:/home";
	}

	@RequestMapping(value = "sobre", method = RequestMethod.GET)
	public String sobre() {
		return "about";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Usuario usuario) {
		
		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			
			Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
			if (u.getSenha().equals(usuario.getSenha())) {
				cpf = usuario.getCpf();
				return "redirect:/home";
			}

			return "redirect:/";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		mv.addObject("usuario", usuario);
		return mv;
	}

	@RequestMapping(value = "/consultaSaldo", method = RequestMethod.GET)
	public ModelAndView consultaSaldo() {
		ModelAndView mav = new ModelAndView("transacoes/consultaSaldo");
		mav.addObject("conta", contaRepository.findByCpf(cpf));
		return mav;
	}

}
