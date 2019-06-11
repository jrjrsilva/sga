package br.gov.ba.pm.sga.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Aluno;
import br.gov.ba.pm.sga.model.Escala;
import br.gov.ba.pm.sga.model.Integrante;
import br.gov.ba.pm.sga.repository.Escalas;

@Service
public class EscalaService {

	@Autowired
	private Escalas escalas;
	
	@Autowired
	private IntegranteService integrantes;
	
	public void salvar(Escala escala){	
		this.escalas.save(escala);
	}

	public Escala findOne(Long id) {
		// TODO Auto-generated method stub
		return this.escalas.findOne(id);
	}

	
	
	public List<Escala> findAll() {
		// TODO Auto-generated method stub
		return this.escalas.findAll();
	}

	public List<Escala> listDescendente() {
		// TODO Auto-generated method stub
		return this.escalas.listDescendente();
	}

	public void delete(Long id) {
		// TODO Auto-generated method st
		this.escalas.delete(id);
	}
	
	public List<Map<String, Object>> report(Long id){
		List<Map<String, Object>> result = new ArrayList<Map<String , Object>>();
		List<Integrante> lista = new ArrayList<Integrante>();
		Escala escala = this.escalas.findOne(id);
	//	if(turma.equals("")) {
			lista = this.integrantes.findByEscala(escala);
	/*	}else {
			lista = this.alunos.findByTurma(turma);
		}*/
		
		for(Integrante inte : lista) {
			Map<String, Object> item = new HashMap<String, Object>();
			/*item.put("numero", inte.getAluno().getNumero());
			item.put("funcao", inte.getFuncao().getNome());
			item.put("nome", inte.getAluno().getNome());
			item.put("turma", inte.getAluno().getTurma());
			item.put("posto", inte.getPosto().getNome());
			item.put("data_est", inte.getEscala().getDataInicio());*/
			result.add(item);
		}
		
		return result;
	}
}
