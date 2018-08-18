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

import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.Vinho;
import br.com.cjm.logistica.service.GrupoService;

@Controller
@RequestMapping("/grupos")
public class GruposController {
	
	@Autowired
	private GrupoService grupos;
	
	/*@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		vinhos.delete(id);
		
		attributes.addFlashAttribute("mensagem", "Vinho removido com sucesso!");
		
		return "redirect:/vinhos";
	}*/
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("grupos/lista-grupos");
		modelAndView.addObject("grupos", grupos.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Grupo grupo) {
		ModelAndView modelAndView = new ModelAndView("grupos/cadastro-grupo");
		
		modelAndView.addObject(grupo);
	//	modelAndView.addObject("tipos", TipoVinho.values());		
		
		return modelAndView;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Grupo grupo, BindingResult result,
			RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(grupo);
		}
		
		grupos.save(grupo);
		
		attributes.addFlashAttribute("mensagem", "Grupo salvo com sucesso!");
		
		return new ModelAndView("redirect:/grupos/novo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(grupos.findOne(id));
	}
}
