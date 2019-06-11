package br.gov.ba.pm.sga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.MatriculaNova;
import br.gov.ba.pm.sga.repository.MatriculaNovaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;
import br.gov.ba.pm.sga.service.exception.ObjectNotFoundException;

@Service
public class MatriculaNovaService {

	@Autowired
	private MatriculaNovaRepository repo;

	public MatriculaNova find(Integer id) {
		return repo.findOne(id);
		/*Optional<MatriculaNova> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + MatriculaNova.class.getName()));
*/
	}
	
	public List<MatriculaNova> findAll() {
		return repo.findAll();
	}
	
	public Page<MatriculaNova> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
	
	public List<MatriculaNova> findByTurma(Integer turma){
		return repo.findByTurma(turma);
	}
		
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma matricula que possui registros");
		}
	}
}
