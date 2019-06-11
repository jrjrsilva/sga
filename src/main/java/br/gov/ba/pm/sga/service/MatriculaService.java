package br.gov.ba.pm.sga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Matricula;
import br.gov.ba.pm.sga.repository.MatriculaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;
import br.gov.ba.pm.sga.service.exception.ObjectNotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repo;

	public Matricula find(Integer id) {
		return repo.findOne(id);
		/*Optional<Matricula> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Matricula.class.getName()));
*/
	}
	
	public List<Matricula> findAll() {
		return repo.findAll();
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
