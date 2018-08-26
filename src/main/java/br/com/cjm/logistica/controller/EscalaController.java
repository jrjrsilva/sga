package br.com.cjm.logistica.controller;

import java.util.ArrayList;

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

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.service.AlunoService;
import br.com.cjm.logistica.service.EscalaService;
import br.com.cjm.logistica.service.FuncaoService;
import br.com.cjm.logistica.service.GrupoServicoService;
import br.com.cjm.logistica.service.IntegranteService;
import br.com.cjm.logistica.service.PostoService;
import br.com.cjm.logistica.service.TipoServicoService;

@Controller
@RequestMapping("/escala")
public class EscalaController {
	


	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private EscalaService escalaService;
	
	@Autowired
	private IntegranteService integranteService;
	
	@Autowired
	private GrupoServicoService grupoServicoService;
	
	@Autowired
	private TipoServicoService tipoServicoService;
	
	@Autowired
	private FuncaoService funcaoService;
	
	@Autowired
	private PostoService postoService;
	
	@Autowired
	private AlunoService alunoService;
		
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("escala/listar");
		Integer grupo = 1;
		modelAndView.addObject("grupos",grupoServicoService.findByGrupo(grupo));
		modelAndView.addObject("escalas", escalaService.listDescendente());
		//TipoServico p = tipoServicoService.findOne(1L);
		modelAndView.addObject("postos",tipoServicoService.findAll());
		return modelAndView;
	}
	
		
	@GetMapping("/novo")
	public ModelAndView novo(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/cadastro");
		modelAndView.addObject("grupos",grupoServicoService.findAll());
		modelAndView.addObject("alunos",new ArrayList<Aluno>());
		modelAndView.addObject(escala);
		
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(escalaService.findOne(id));
	}
	
	@GetMapping("/detalhe/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		return detalhar(escalaService.findOne(id));
	}
	
	public ModelAndView detalhar(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/detalhe");
				
		modelAndView.addObject("grupo",escala.getGrupoServico());
		modelAndView.addObject("alunos",escala.getGrupoServico().getAlunos());
		modelAndView.addObject("funcoes",funcaoService.findAll());
		modelAndView.addObject("postos",postoService.findAll());
		modelAndView.addObject("escala",escala);
		modelAndView.addObject("integrantes",integranteService.findByEscalaAndPosto(escala.getId()));
		modelAndView.addObject("integrantesPavA",integranteService.findByEscalaAndPosto(escala.getId(),3L));
		modelAndView.addObject("integrantesPavB",integranteService.findByEscalaAndPosto(escala.getId(),4L));
		modelAndView.addObject("integrantesPavD",integranteService.findByEscalaAndPosto(escala.getId(),5L));
		modelAndView.addObject("integrantesPavR",integranteService.findByEscalaAndPosto(escala.getId(),8L));
		
		return modelAndView;
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
