package br.com.cjm.logistica.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.model.Integrante;
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
	
	/**
	 * desta forma passo dois parametros para o controller
	 * o id vai por get e pego o escalaid por RequestParam
	 * @{/escala/detalhe/delete/{id}(id=${intR.aluno.id},escalaid=${escala.id})}
	 * 
	 */


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
		modelAndView.addObject("tiposServico",tipoServicoService.findAll());
		return modelAndView;
	}
	
		
	@GetMapping("/novo")
	public ModelAndView novo(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/cadastro");
		modelAndView.addObject("grupos",grupoServicoService.findAll());
		modelAndView.addObject("tiposServico",tipoServicoService.findAll());
		modelAndView.addObject("alunos",new ArrayList<Aluno>());
		modelAndView.addObject(escala);
		
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(escalaService.findOne(id));
	}
	
	@GetMapping("/detalhe/{id}")
	public ModelAndView detalharEscala(@PathVariable Long id) {
		return detalharEscalaObjeto(escalaService.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView remover(@PathVariable Long id) {
		
		escalaService.delete(id);
		
		return new ModelAndView("redirect:/escala");
	}
	
	@GetMapping("/detalhe/delete/{id}")
	public ModelAndView removerAluno(@PathVariable Long id) {
		
		Escala escala = escalaService.findOne(integranteService.findOne(id).getEscala().getId());
		integranteService.delete(id);
		
		return detalharEscala(escala.getId());
	}
	
	
	
	@PostMapping("/detalhe/add")
	public ModelAndView add(@RequestParam("id") Long id, 
							      @RequestParam("aluno") Long aluno,
							      @RequestParam("posto") Long posto,
							      @RequestParam("funcao") Long funcao) {
		
	
		Escala escala = escalaService.findOne(id);
		Integrante integrante = new Integrante();
		integrante.setAluno(alunoService.findOne(aluno));
		integrante.setEscala(escala);
		integrante.setPosto(postoService.findOne(posto));
		integrante.setFuncao(funcaoService.findOne(funcao));
		integranteService.salvar(integrante);
				
		return detalharEscalaObjeto(escalaService.findOne(id));
	
	}
	
	@RequestMapping(value="/detalhe/repEscala/{id}", method = RequestMethod.GET)
	public ModelAndView report(RedirectAttributes attributes,@PathVariable Long id){
		JasperReportsPdfView view = new JasperReportsPdfView();
		//JRDocxExporter view = new JRDocxExporter();
		view.setUrl("classpath:/reports/servicoInterno.jrxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params = new HashMap<String, Object>();
		//if(turma.equals(""))
			params.put("datasource", escalaService.report(id));
		
	//	attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView(view, params);
		
	}
	
	public ModelAndView detalharEscalaObjeto(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/detalhe");
		List<Aluno> escalados = integranteService.findByAlunoEscala(escala);
		List<Aluno> noGrupo = escala.getGrupoServico().getAlunos();
		List<Aluno> paraEscalar = new ArrayList<Aluno>();
		
		paraEscalar.addAll(noGrupo);
		paraEscalar.removeAll(escalados);
		
				
		modelAndView.addObject("grupo",escala.getGrupoServico());
		modelAndView.addObject("alunos",paraEscalar);
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
			RedirectAttributes attributes,
			@RequestParam("grupo") Long grupoId,
			@RequestParam("tipoServico") Long tipoServicoId) {
		if (result.hasErrors()) {
			return novo(escala);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(escala.getDataInicio());
		c.add(Calendar.DAY_OF_MONTH,1);
		escala.setDataFim(c.getTime());
		escala.setGrupoServico(grupoServicoService.findOne(grupoId));
		escala.setTipoServico(tipoServicoService.findOne(tipoServicoId));
		escala.setNome("serviço diario");
		this.escalaService.salvar(escala);

		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView("redirect:/escala");
	}
	
	
}
