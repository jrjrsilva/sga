package br.com.cjm.logistica.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.repository.Alunos;



@Service
public class AlunoService {

	@Autowired
	private Alunos alunos;
	
	
	public void salvar(Aluno aluno){
		this.alunos.save(aluno);
	}
	
	public Aluno buscar(String matricula){
		return this.alunos.findByMatricula(matricula);
	}
	
	public Aluno findByNumero(Integer numero){
		return this.alunos.findByNumero(numero);
	}
	
    public List<Aluno> obterPorTurmaCurso(String turma, String curso){
    	return this.alunos.obterPorTurmaCurso(turma, curso);
    }
	
	public List<Aluno> pesquisaNomeGuerra (String nomeGuerra){
		return this.alunos.findByNomeGuerra(nomeGuerra);
	}

	public List<Aluno> findAll() {
		return this.alunos.findAll();
	}

	public Aluno findOne(Long id) {
		return this.alunos.findOne(id);
	}	
	
	public List<Map<String, Object>> report(){
		List<Map<String, Object>> result = new ArrayList<Map<String , Object>>();
		List<Aluno> lista = new ArrayList<Aluno>();
	//	if(turma.equals("")) {
			lista = this.alunos.findAll();
	/*	}else {
			lista = this.alunos.findByTurma(turma);
		}*/
		
		for(Aluno aluno : lista) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("numero", aluno.getNumero());
			item.put("nomeGuerra", aluno.getNomeGuerra());
			item.put("nome", aluno.getNome());
			item.put("turma", aluno.getTurma());
			result.add(item);
		}
		
		return result;
	}
	
	public List<String> matriculas(){
		List<String> result = new ArrayList<String>();
		for(Aluno aluno : this.alunos.findAll()) {	
			result.add(aluno.getMatricula());
		}
		return result;
	}

	public Aluno adicionar(Aluno aluno) {
		return alunos.save(aluno);
	}
		
}
