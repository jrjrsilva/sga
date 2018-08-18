package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.TipoServico;
import br.com.cjm.logistica.repository.TiposServico;


@Service
public class TipoServicoService {

	@Autowired
	private TiposServico tiposServico;
	
	public void salvar(TipoServico tipoServico){
		this.tiposServico.save(tipoServico);
	}
	
	
	public List<TipoServico> pesquisaNome (String nome){
		return this.tiposServico.findByNomeContaining(nome);
	}


	public List<TipoServico> findAll() {
		// TODO Auto-generated method stub
		return this.tiposServico.findAll();
	}


	public void save(TipoServico tipoServico) {
		// TODO Auto-generated method stub
		this.tiposServico.save(tipoServico);
	}


	public TipoServico findOne(Long id) {
		// TODO Auto-generated method stub
		return this.tiposServico.findOne(id);
	}
	
}
