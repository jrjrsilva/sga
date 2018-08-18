package br.com.cjm.logistica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.model.Posto;
import br.com.cjm.logistica.model.TipoServico;
import br.com.cjm.logistica.service.EscalaService;
import br.com.cjm.logistica.service.GrupoServicoService;
import br.com.cjm.logistica.service.TipoServicoService;

@Controller
@RequestMapping("/escala")
public class EscalaController {
	


	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private EscalaService escalaService;
	
	@Autowired
	private GrupoServicoService grupoServicoService;
	
	@Autowired
	private TipoServicoService tipoServicoService;
		
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("escala/listar");
		Integer grupo = 1;
		modelAndView.addObject("grupos",grupoServicoService.findByGrupo(grupo));
		modelAndView.addObject("escalas", escalaService.findAll());
		TipoServico p = tipoServicoService.findOne(1L);
		modelAndView.addObject("postos",p.getPostos());
		return modelAndView;
	}
	
		
	@GetMapping("/novo")
	public ModelAndView novo(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/cadastro");
		modelAndView.addObject("grupos",grupoServicoService.findAll());
		
		modelAndView.addObject(escala);
		
		TipoServico p = tipoServicoService.findOne(1L);
		System.out.println("Tipo de Serviço: "+ p.getNome());
		for(Posto pp : p.getPostos()) {
			System.out.println("Pessoa "+ pp.getNome());
		}
		
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(escalaService.findOne(id));
	}
	
	

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Escala escala, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(escala);
		}
		this.escalaService.salvar(escala);
		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView("redirect:/escala/listar");
	}
	
	
}
