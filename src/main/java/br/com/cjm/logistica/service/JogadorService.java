package br.com.cjm.logistica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cjm.logistica.model.Jogador;
import br.com.cjm.logistica.repository.Jogadores;



@Service
public class JogadorService {

	@Autowired
	private Jogadores jogadores;
	
	public void salvar(Jogador produto){
		this.jogadores.save(produto);
	}
	
	
	
	
}
