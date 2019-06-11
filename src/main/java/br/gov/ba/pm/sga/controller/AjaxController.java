package br.gov.ba.pm.sga.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ba.pm.sga.model.Aluno;
import br.gov.ba.pm.sga.service.AlunoService;

@RestController
public class AjaxController {
	@Autowired
	AlunoService alunoSerice;
	
	/*public ResponseEntity<Aluno> obterAlunoAjax(@Valid @RequestBody Integer search, Errors errors){
		AjaxResponseBody result = new AjaxResposeBody();
	}*/
}
