package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Turma;
import br.gov.ba.pm.sga.repository.TurmaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;

	public Turma find(Integer id) {
		return repo.findOne(id);
			/*Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
*/
	}
	
	public List<Turma> findAll() {
		return repo.findAll();
	}
	
	public Page<Turma> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
	
	public Page<Turma> findPageTurma(Integer page, Integer linesPerPage,String orderBy, String direction,
			Long disiciplina, Long Turma){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
	
	public List<Turma> findByAno(Integer ano){
		return repo.findByAno(ano);
	}
		
	public List<Integer> findAnoAll() {
		return repo.findByAnoAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Turma que possui registros");
		}
	}
}
