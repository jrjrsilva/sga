package br.gov.ba.pm.sga.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.ba.pm.sga.model.Disciplina;
import br.gov.ba.pm.sga.model.Nota;
import br.gov.ba.pm.sga.model.Turma;
import br.gov.ba.pm.sga.service.DisciplinaService;
import br.gov.ba.pm.sga.service.GradeService;
import br.gov.ba.pm.sga.service.MatriculaNovaService;
import br.gov.ba.pm.sga.service.NotaService;
import br.gov.ba.pm.sga.service.TurmaService;

@Controller
@RequestMapping("/notas")
public class NotaController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private NotaService service;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private MatriculaNovaService matriculaNovaService;
	
	@Autowired
	private GradeService gradeService;
	
			
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("/nota/listar");
		List page = new ArrayList<>();
		modelAndView.addObject("page", page);
		//modelAndView.addObject("turmas",turmaService.findAll());
		modelAndView.addObject("anos",turmaService.findAnoAll());
		//modelAndView.addObject("disciplinas",disciplinaService.findAll());
		return modelAndView;
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(@RequestParam("turma") Integer turma, @RequestParam("disciplina") Integer disciplina) {
		ModelAndView modelAndView = new ModelAndView("/nota/listar");
		List page = service.findByTurmaDisciplinaSemestre(turma,disciplina,"1");
		
		modelAndView.addObject("page", page);
		modelAndView.addObject("anos",turmaService.findAnoAll());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/turmas",method=RequestMethod.GET)
	public ResponseEntity<List<Turma>> findTurmasAno(
			@RequestParam(value="anoTurma") Integer ano) {
		List<Turma> list = turmaService.findByAno(ano);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/find/{codNota}",method=RequestMethod.GET)
	public ResponseEntity<Nota> findNota(@PathVariable Integer codNota) {
		Nota nota = service.find(codNota);
		return ResponseEntity.ok().body(nota);
	}
	
	@RequestMapping(value="/disciplinas",method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> findDisciplinasTurma(
			@RequestParam(value="codTurma") Integer codTurma,
			@RequestParam(value="semestre") String semestre) {
		List<Disciplina> list = gradeService.findByCodTurmaAndSemestre(codTurma, semestre);
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping("/listagem")
	public ModelAndView listaNotas(@RequestParam("turma") Integer turma, 
			@RequestParam("disciplina") Integer disciplina,
			@RequestParam("semestre") String semestre) {
		String modelTabela = "";
		if(semestre.equals("1")) {
			modelTabela = "/nota/tabela";
		}else if (semestre.equals("2")) {
			modelTabela = "/nota/tabela2";
		}
		ModelAndView modelAndView = new ModelAndView(modelTabela);
		List page = service.findByTurmaDisciplinaSemestre(turma,disciplina,semestre);
				
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Nota nota) {
		ModelAndView modelAndView = new ModelAndView("nota/cadastro");
		modelAndView.addObject(nota);
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Integer id) {
		return novo(service.find(id));
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Nota nota, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(nota);
		}
		Nota obj = this.service.find(nota.getCodNota());
	
		this.service.update(obj, 1);
		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView("redirect:/nota/listar");
	}
	
	@RequestMapping(value="/nova1s",  method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Nota> nova1s(@RequestBody(required=true)Map<String, Object> corpo) {
		Nota obj = new Nota();
		obj.setCodNota(Integer.parseInt(corpo.get("codNota").toString()));
		obj.setvC11Sem(Float.parseFloat(corpo.get("vc1").toString()));
		obj.setvC21Sem(Float.parseFloat(corpo.get("vc2").toString()));
		obj.setvF1Sem(Float.parseFloat(corpo.get("vf1").toString()));
		obj.setRec1Sem(Float.parseFloat(corpo.get("rec1").toString()));
		obj.setCons1Sem(Float.parseFloat(corpo.get("cons1").toString()));
		obj.setSemestre(corpo.get("semestre").toString());
		this.service.update(obj, 1);
	
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/nova2s",  method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Nota> nova2s(@RequestBody(required=true)Map<String, Object> corpo) {
		Nota obj = new Nota();
		obj.setCodNota(Integer.parseInt(corpo.get("codNota").toString()));
		obj.setvC12Sem(Float.parseFloat(corpo.get("vc1").toString()));
		obj.setvC22Sem(Float.parseFloat(corpo.get("vc2").toString()));
		obj.setvF2Sem(Float.parseFloat(corpo.get("vf2").toString()));
		obj.setRec2Sem(Float.parseFloat(corpo.get("rec2").toString()));
		obj.setCons2Sem(Float.parseFloat(corpo.get("cons2").toString()));
		obj.setSemestre(corpo.get("semestre").toString());
		this.service.update(obj, 2);	
		
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
	
	*/
	
	
}
