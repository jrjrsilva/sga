package br.com.cjm.logistica.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.repository.Alunos;
import br.com.cjm.logistica.service.AlunoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/alunos")
public class AlunoResource {
	

	@Autowired
	private Alunos alunos;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listar() {
		return alunos.findAll();
	}
	
	@PostMapping
	public Aluno adicionar(@RequestBody @Valid Aluno aluno) {
		return alunoService.adicionar(aluno);
	}

	/*@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private GrupoServicoService grupoService;
		
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("aluno/listar");
		modelAndView.addObject("alunos", alunoService.findAll());
		return modelAndView;
	}
	
	@PostMapping("/turma")
	public ModelAndView turma(@RequestParam("turma") String turma,@RequestParam("curso") String curso) {
		ModelAndView modelAndView = new ModelAndView("aluno/listar");
		if(turma.equals("")) {
			modelAndView.addObject("alunos",alunoService.findAll());
		}else {
			modelAndView.addObject("alunos",alunoService.obterPorTurmaCurso(turma, curso));
		}
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("aluno/cadastro");
		modelAndView.addObject(aluno);
		modelAndView.addObject("grupos",aluno.getGruposServico());
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
		System.out.println("oi");
		Aluno aluno = alunoService.findOne(id);
		modelAndView.addObject(aluno);
		System.out.println(grupo);
		System.out.println(id);
		modelAndView.addObject("grupos",grupoService.findAll());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(alunoService.findOne(id));
	}
	
	@RequestMapping(value="report", method = RequestMethod.GET)
	public ModelAndView report(RedirectAttributes attributes){
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:/reports/geral.jrxml");
		view.setApplicationContext(applicationContext);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datasource", alunoService.report());
		
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
		aluno.setSexo(al.getSexo());
		aluno.setCodgrauhierarquico(al.getCodgrauhierarquico());
		aluno.setCodopm(al.getCodopm());
		aluno.setGrauhierarquico(al.getGrauhierarquico());
		aluno.setOpm(al.getOpm());
		aluno.setNascimento(al.getNascimento());
		aluno.setAdmissao(al.getAdmissao());
		aluno.setCurso(al.getCurso());
		this.alunoService.salvar(aluno);
		
		attributes.addFlashAttribute("mensagem", "salvo com sucesso!");
		
		return new ModelAndView("redirect:/aluno/listar");
	}*/
	
	
}
