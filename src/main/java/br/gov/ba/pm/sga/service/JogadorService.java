package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Jogador;
import br.gov.ba.pm.sga.repository.Jogadores;



@Service
public class JogadorService {

	@Autowired
	private Jogadores jogadores;
	
	public void salvar(Jogador produto){
		this.jogadores.save(produto);
	}
	
	
	
	
}
