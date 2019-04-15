package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private String cnpj;

	@RequestMapping("/")
	public String index() {
		cpf = null;
		cnpj = null;
		return "index";
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String cadastrarCliente() {
		return "cadastro/cadastroCliente";
	}

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String cadastrarCliente(Usuario usuario, Endereco endereco) {
		usuario.setEndereco(endereco);
		cpf = usuario.getCpf();
		cnpj = usuario.getCnpj();
		usuarioRepository.save(usuario);
		return "redirect:/cadastrarConta";

	}

	@RequestMapping(value = "/cadastrarConta", method = RequestMethod.GET)
	public ModelAndView cadastrarConta() {
		ModelAndView mav = new ModelAndView("cadastro/CadastroConta");
		if (cpf != null)
			mav.addObject("cpf", cpf);
		else if (cnpj != null)
			mav.addObject("cnpj", cnpj);
		return mav;
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
	public String login(Usuario usuario, RedirectAttributes attributes) {
		cpf = null;
		cnpj = null;

		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {

			Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
			if (u.getSenha().equals(usuario.getSenha())) {
				if (u.getCpf() != null)
					cpf = u.getCpf();
				else if (u.getCnpj() != null)
					cnpj = u.getCnpj();
				return "redirect:/home";
			}
			attributes.addFlashAttribute("mensagem", "Email ou senha incorretos");
			return "redirect:/login";
		}
		attributes.addFlashAttribute("mensagem", "Email ou senha incorretos");
		return "redirect:/login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		Usuario usuario = null;
		if (cpf != null) {
			usuario = usuarioRepository.findByCpf(cpf);
			System.out.println(cpf);
		} else if (cnpj != null) {
			usuario = usuarioRepository.findByCnpj(cnpj);
			System.out.println(cnpj);
		}
		mv.addObject("usuario", usuario);
		return mv;
	}

	@RequestMapping(value = "/consultaSaldo", method = RequestMethod.GET)
	public ModelAndView consultaSaldo() {
		ModelAndView mav = new ModelAndView("transacoes/consultaSaldo");
		if (cpf != null)
			mav.addObject("conta", contaRepository.findByCpf(cpf));
		else if (cnpj != null)
			mav.addObject("conta", contaRepository.findByCnpj(cnpj));

		return mav;
	}

	@RequestMapping("/esqueceuSenha")
	public String esqueceuSenha() {
		return "esqueceuSenha";
	}

	@RequestMapping(value = "/emprestimo", method = RequestMethod.GET)
	public ModelAndView emprestimo() {
		ModelAndView mav = new ModelAndView("transacoes/emprestimo");
		if (cpf != null)
			mav.addObject("conta", contaRepository.findByCpf(cpf));
		else if (cnpj != null)
			mav.addObject("conta", contaRepository.findByCnpj(cnpj));
		return mav;

	}

	@RequestMapping(value = "/emprestimo", method = RequestMethod.POST)
	public ModelAndView emprestimo(String var) {
		ModelAndView mav = new ModelAndView("transacoes/emprestimo");
		Conta conta=null;
		double juros=0.0;
		
		if (cpf != null) {
			conta=contaRepository.findByCpf(cpf);
			mav.addObject("conta", conta);
			mav.addObject("disponivel", (conta.getSalarioLiquido()/2)*12);
			if(conta.getSalarioLiquido()<1000) {
				juros=0.02;
				mav.addObject("juros", juros);
				
			}else if(conta.getSalarioLiquido()<5000) {
				juros=0.05;
				mav.addObject("juros", juros);
				
			}else {
				juros=0.1;
				mav.addObject("juros", juros);
			}
			
			
		} else if (cnpj != null) {
			mav.addObject("conta", contaRepository.findByCnpj(cnpj));
		}
		return mav;

	}
}
