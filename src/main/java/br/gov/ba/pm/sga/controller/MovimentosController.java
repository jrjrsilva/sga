package br.gov.ba.pm.sga.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Movimentos;
import br.gov.ba.pm.sga.repository.Produtos;
import br.gov.ba.pm.sga.service.GrupoService;

@Controller
@RequestMapping("/movimentos")
public class MovimentosController {
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private GrupoService grupos;
	
	@Autowired
	private Movimentos movimentos;
	
		
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("movimentos/lista-movimentos");
		modelAndView.addObject("movimentos", movimentos.porDataMovimento());
		
		return modelAndView;
	}
		
}
