package br.gov.ba.pm.sga.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.ba.pm.sga.model.Disciplina;
import br.gov.ba.pm.sga.model.Grade;
import br.gov.ba.pm.sga.model.Nota;
import br.gov.ba.pm.sga.model.Serie;
import br.gov.ba.pm.sga.model.Turma;
import br.gov.ba.pm.sga.service.DisciplinaService;
import br.gov.ba.pm.sga.service.GradeService;
import br.gov.ba.pm.sga.service.SerieService;
import br.gov.ba.pm.sga.service.TurmaService;
import jnr.ffi.types.sa_family_t;

@Controller
@RequestMapping("/grades")
public class GradeController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private GradeService service;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Integer id) {
		return novo(service.find(id));
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Grade grade) {
		ModelAndView modelAndView = new ModelAndView("grade/cadastro");
		modelAndView.addObject(grade);
		modelAndView.addObject("anos",turmaService.findAnoAll());
		modelAndView.addObject("disciplinas",disciplinaService.findAll());
		return modelAndView;
	}
			
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/grade/listar");
		Page<Grade> page = service.findPage(0, 300, "ano", "DESC");
		modelAndView.addObject("page", page);
		modelAndView.addObject("anos",turmaService.findAnoAll());
		modelAndView.addObject("sumario", page.getNumberOfElements());
		modelAndView.addObject("disciplinas",disciplinaService.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/listagem")
	public ModelAndView listaGrades(@RequestParam("turma") Integer turma, 
				@RequestParam("semestre") String semestre) {
			
			ModelAndView modelAndView = new ModelAndView("/grade/tabela");
			List<Grade> page = service.findByTurmaAndSemestre(turma, semestre);
			modelAndView.addObject("page", page);
			
			return modelAndView;
	}
	
	@RequestMapping(value="/novo",  method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Grade> nova1s(@RequestBody(required=true)Map<String, Object> corpo) {
		Grade obj = new Grade();
		Disciplina disciplina = new Disciplina();
		disciplina = disciplinaService.find(Integer.parseInt(corpo.get("disciplina").toString()));
		Turma turma = new Turma();
		turma = turmaService.find(Integer.parseInt(corpo.get("turma").toString()));
		obj.setAno(Integer.parseInt(corpo.get("anoturma").toString()));
		obj.setDisciplina(disciplina);
		obj.setTurma(turma);
		obj.setSerie(turma.getSerie());
		obj.setSemestre(corpo.get("semestre").toString());
		this.service.insert(obj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grade> excluir(@PathVariable("id") Integer id) {
		Grade obj = new Grade();
		obj = service.find(id);
		service.delete(obj.getCodItemturma());
        return ResponseEntity.ok().body(obj);
    }

	
	/*@PostMapping("/turma")
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
	
	@GetMapping("/grupos/{id}")
	public ModelAndView gruposServico(@PathVariable Long id) {
		return grupos(alunoService.findOne(id));
	}
		 
	@GetMapping("/grupos")
	public ModelAndView grupos(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("aluno/grupos");
		modelAndView.addObject(aluno);
		modelAndView.addObject("grupos",grupoService.findAll());
		return modelAndView;
	}

	@GetMapping("/grupos/novo/{id}/{grupo}")
	public ModelAndView gruposAdd(@PathVariable Long id, @PathVariable Long grupo) {
		ModelAndView modelAndView = new ModelAndView("aluno/grupos");
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(alunoService.findOne(id));
	}
	
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
	
	@RequestMapping(value="report", method = RequestMethod.GET)
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
		
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Aluno aluno, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(aluno);
		}
		Aluno al = this.alunoService.findOne(aluno.getId());
	
		al.setTelefone(aluno.getTelefone());
		al.setEmail(aluno.getEmail());
		al.setDdd(aluno.getDdd());
		al.setEndereco(aluno.getEndereco());
		al.setNomeGuerra(aluno.getNomeGuerra());
		this.alunoService.salvar(al);
		
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
	}*/
	
	
}
