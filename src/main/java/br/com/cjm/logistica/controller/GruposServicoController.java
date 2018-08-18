package br.com.cjm.logistica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import br.com.cjm.logistica.model.GrupoServico;
import br.com.cjm.logistica.service.GrupoServicoService;

@Controller
@RequestMapping("/gruposservico")
public class GruposServicoController {
	
	@Autowired
	private GrupoServicoService grupoServicoService;
	
	/*@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		vinhos.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Vinho removido com sucesso!");
		
		return "redirect:/vinhos";
	}*/
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("gruposservico/listar");
		modelAndView.addObject("grupos", grupoServicoService.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(GrupoServico gruposervico) {
		ModelAndView modelAndView = new ModelAndView("gruposservico/cadastro");
		modelAndView.addObject(gruposervico);
		return modelAndView;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid GrupoServico gruposervico, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(gruposervico);
		}
		
		grupoServicoService.save(gruposervico);
		attributes.addFlashAttribute("mensagem", "Grupo salvo com sucesso!");
		return new ModelAndView("redirect:gruposservico/novo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(grupoServicoService.findOne(id));
	}
}