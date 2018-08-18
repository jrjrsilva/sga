package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Grupo;
import br.com.cjm.logistica.model.GrupoServico;
import br.com.cjm.logistica.repository.GruposServico;



@Service
public class GrupoServicoService {

	@Autowired
	private GruposServico grupos;
	
	public void salvar(GrupoServico grupo){
		this.grupos.save(grupo);
	}
	
	
	public List<GrupoServico> pesquisaNome (String nome){
		return this.grupos.findByNomeContaining(nome);
	}


	public List<GrupoServico> findAll() {
		// TODO Auto-generated method stub
		return this.grupos.findAll();
	}

	public List<GrupoServico> findByGrupo(Integer grupo) {
		// TODO Auto-generated method stub
		return this.grupos.findByGrupo(grupo);
	}

	public void save(GrupoServico grupo) {
		// TODO Auto-generated method stub
		this.grupos.save(grupo);
	}


	public GrupoServico findOne(Long id) {
		// TODO Auto-generated method stub
		return this.grupos.findOne(id);
	}
		
	
	
	
}
