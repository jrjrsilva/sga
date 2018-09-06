package br.com.cjm.logistica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.model.Escala;
import br.com.cjm.logistica.model.Integrante;
import br.com.cjm.logistica.model.Posto;
import br.com.cjm.logistica.repository.Integrantes;


@Service
public class IntegranteService {

	@Autowired
	private Integrantes integrantes;
	
	public void salvar(Integrante integrante){
		this.integrantes.save(integrante);
	}
		
	public List<Integrante> findAll() {
		// TODO Auto-generated method stub
		return this.integrantes.findAll();
	}

	public Integrante findOne(Long id) {
		// TODO Auto-generated method stub
		return this.integrantes.findOne(id);
	}

	public List<Integrante> findByEscala(Escala escala) {
		return this.integrantes.findByEscala(escala);
	}
	
	public List<Aluno> findByAlunoEscala(Escala escala) {
		List<Aluno> retorno = new ArrayList<Aluno>();
		List<Integrante> escalados = this.integrantes.findByEscala(escala);
		for(Integrante aluno : escalados ) {
			retorno.add(aluno.getAluno());
		}
		
		return retorno ;
	}
	
	
	public List<Integrante> findByEscalaAndPosto(Escala escala,Posto posto) {
		return this.integrantes.findByEscalaAndPosto(escala,posto);
	}

	public List<Integrante> findByEscalaAndPosto(Long escalaId, Long postoId) {
		return this.integrantes.findByEscalaAndPosto(escalaId,postoId);
	}

	public List<Integrante> findByEscalaAndPosto(Long escalaId) {
		return this.integrantes.findByEscalaAndPosto(escalaId);
	}

	

	public void delete(Long id) {
		this.integrantes.delete(id);
	}
	
}
