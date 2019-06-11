package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Disciplina;
import br.gov.ba.pm.sga.model.Turma;
import br.gov.ba.pm.sga.repository.DisciplinaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;

	public Disciplina find(Integer id) {
		return repo.findOne(id);
			/*Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
*/
	}
	
	public List<Disciplina> findAll() {
		return repo.findAll();
	}
	
	public Page<Disciplina> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
	
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Disciplina que possui registros");
		}
	}
}
