package br.gov.ba.pm.sga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.gov.ba.pm.sga.service.AlunoService;

@Controller
public class Export {

	/*@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(Model model) {
	    model.addAttribute("alunos", alunoService.findAll());
	    return "";
	}*/
}
