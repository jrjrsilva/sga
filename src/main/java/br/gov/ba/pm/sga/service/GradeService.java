package br.gov.ba.pm.sga.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Disciplina;
import br.gov.ba.pm.sga.model.Grade;
import br.gov.ba.pm.sga.model.Nota;
import br.gov.ba.pm.sga.repository.GradeRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class GradeService {

	@Autowired
	private GradeRepository repo;
	
	@Autowired
	private TurmaService turmaService;

	public Grade find(Integer id) {
		return repo.findOne(id);
		/*return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Grade.class.getName()));
*/
	}
	
	public Grade insert(Grade obj) {
		obj.setCodItemturma(null);
		return repo.save(obj);
	}
	
	public List<Grade> findAll() {
		return repo.findAll();
	}
	
	public List<Integer> findAnoAll() {
		return turmaService.findAnoAll();
	}
	
	public Page<Grade> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
	
	
	public List<Disciplina> findByCodTurmaAndSemestre(Integer codTurma,String semestre){		 
		
		List list = repo.findByTurmaAndSemestre(codTurma, semestre);
		List<Disciplina> listDisciplina = new ArrayList<>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Grade grade = (Grade) iterator.next();
			listDisciplina.add(grade.getDisciplina());
		} 
		
		return listDisciplina;
	}
	
	public List<Grade> findByTurmaAndSemestre(Integer codTurma,String semestre){		 
		
		List list = repo.findByTurmaAndSemestre(codTurma, semestre);
		
		return list;
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Item que possui registros");
		}
	}
}
