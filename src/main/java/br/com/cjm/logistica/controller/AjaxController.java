package br.com.cjm.logistica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cjm.logistica.model.Aluno;
import br.com.cjm.logistica.service.AlunoService;

@RestController
public class AjaxController {
	@Autowired
	AlunoService alunoSerice;
	
	/*public ResponseEntity<Aluno> obterAlunoAjax(@Valid @RequestBody Integer search, Errors errors){
		AjaxResponseBody result = new AjaxResposeBody();
	}*/
}
