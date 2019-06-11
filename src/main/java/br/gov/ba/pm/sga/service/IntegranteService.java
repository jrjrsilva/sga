package br.gov.ba.pm.sga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Aluno;
import br.gov.ba.pm.sga.model.Escala;
import br.gov.ba.pm.sga.model.Integrante;
import br.gov.ba.pm.sga.model.Posto;
import br.gov.ba.pm.sga.repository.Integrantes;


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
