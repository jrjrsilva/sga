package br.gov.ba.pm.sga.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Inventario;
import br.gov.ba.pm.sga.model.Inventariomp;
import br.gov.ba.pm.sga.model.Movimento;
import br.gov.ba.pm.sga.model.Produto;
import br.gov.ba.pm.sga.repository.Inventariomps;
import br.gov.ba.pm.sga.repository.Inventarios;
import br.gov.ba.pm.sga.repository.Movimentos;



@Service
public class InventariompService {

	@Autowired
	private Inventariomps inventariomps;
	
		
	
	public List<Inventariomp> getAllInventarios() {
		return (List<Inventariomp>) inventariomps.findAll();
	}
	
	public void salvar(Inventariomp inventario){
		this.inventariomps.save(inventario);
	}
	
	public List<Inventariomp> obterPorAno (String ano){
		return this.inventariomps.findByAno(ano);
	}
	
	
}
