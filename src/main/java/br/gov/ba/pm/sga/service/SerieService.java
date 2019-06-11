package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Serie;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class SerieService {

	@Autowired
	private br.gov.ba.pm.sga.repository.SerieRepository repo;

	public Serie find(Integer id) {
		return repo.findOne(id);
		/*Optional<Serie> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Serie.class.getName()));
*/
	}
	
	public List<Serie> findAll() {
		return repo.findAll();
	}
	
	public Page<Serie> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
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
			throw new DataIntegrityException("Não é possível excluir um Aluno que possui registros");
		}
	}
}
