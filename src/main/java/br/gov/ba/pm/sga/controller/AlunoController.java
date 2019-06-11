package br.gov.ba.pm.sga.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

import br.gov.ba.pm.sga.model.Aluno;
import br.gov.ba.pm.sga.service.AlunoService;
import br.gov.ba.pm.sga.service.GrupoServicoService;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private AlunoService service;
	
	
		
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/aluno/listar");
		//modelAndView.addObject("alunos", service.findAll());
		Page page = service.findPage(0, 300, "alunoNome", "DESC");
		modelAndView.addObject("page", page);
		modelAndView.addObject("sumario", page.getNumberOfElements());
		
		return modelAndView;
	}
	
	@PostMapping("/turma")
	public ModelAndView turma(@RequestParam("turma") String turma,@RequestParam("curso") String curso) {
		ModelAndView modelAndView = new ModelAndView("/aluno/listar");
		if(turma.equals("")) {
			modelAndView.addObject("alunos",service.findAll());
		}else {
			//modelAndView.addObject("alunos",alunoService.obterPorTurmaCurso(turma, curso));
		}
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("aluno/cadastro");
		modelAndView.addObject(aluno);
		//modelAndView.addObject("grupos",aluno.getGruposServico());
		return modelAndView;
	}
	
	/*@GetMapping("/grupos/{id}")
	public ModelAndView gruposServico(@PathVariable Long id) {
		return grupos(alunoService.findOne(id));
	}*/
		 
	

	@GetMapping("/grupos/novo/{id}/{grupo}")
	public ModelAndView gruposAdd(@PathVariable Long id, @PathVariable Long grupo) {
		ModelAndView modelAndView = new ModelAndView("aluno/grupos");
		return modelAndView;
	}
	
	/*@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(alunoService.findOne(id));
	}*/
	
	@RequestMapping(value="report", method = RequestMethod.GET)
	public ModelAndView report(RedirectAttributes attributes){
		JasperReportsPdfView view = new JasperReportsPdfView();
		//JRDocxExporter view = new JRDocxExporter();
		view.setUrl("classpath:/reports/geral.jrxml");
		view.setApplicationContext(applicationContext);
		
		Map<String, Object> params = new HashMap<String, Object>();
		//if(turma.equals(""))
	//		params.put("datasource", alunoService.report());
		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView(view, params);
		
	}
	
	/*@RequestMapping(value="report", method = RequestMethod.GET)
	public ModelAndView report(RedirectAttributes attributes,@RequestParam("turma") String turma){
		JasperReportsPdfView view = new JasperReportsPdfView();
		//JRDocxExporter view = new JRDocxExporter();
		view.setUrl("classpath:/reports/geral.jrxml");
		view.setApplicationContext(applicationContext);
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(turma.equals(""))
			params.put("datasource", alunoService.report(turma));
		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView(view, params);
		
	}*/

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Aluno aluno, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(aluno);
		}
		/*Aluno al = this.alunoService.findOne(aluno.getId());
	
		al.setTelefone(aluno.getTelefone());
		al.setEmail(aluno.getEmail());
		al.setDdd(aluno.getDdd());
		al.setEndereco(aluno.getEndereco());
		al.setNomeGuerra(aluno.getNomeGuerra());
		this.alunoService.salvar(al);
		*/
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView("redirect:/aluno/listar");
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<Aluno>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="30")Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="alunoNome")String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction) {
		Page<Aluno> list = service.findPage(page,linesPerPage,orderBy,direction);
		System.out.println(list);
		
		return ResponseEntity.ok().body(list);
	}
	
	
}
