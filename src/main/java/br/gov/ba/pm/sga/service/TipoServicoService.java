package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.TipoServico;
import br.gov.ba.pm.sga.repository.TiposServico;


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
