package br.gov.ba.pm.sga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Profdisciplina;
import br.gov.ba.pm.sga.repository.ProfdisciplinaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;
import br.gov.ba.pm.sga.service.exception.ObjectNotFoundException;

@Service
public class ProfdisciplinaService {

	@Autowired
	private ProfdisciplinaRepository repo;

	public Profdisciplina find(Integer id) {
		return repo.findOne(id);
		/*Optional<Profdisciplina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Profdisciplina.class.getName()));
*/
	}
	
	public List<Profdisciplina> findAll() {
		return repo.findAll();
	}
	
	public Page<Profdisciplina> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
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
			throw new DataIntegrityException("Não é possível excluir um Profdisciplina que possui registros");
		}
	}

	public void save(Profdisciplina profdisciplina) {
		this.repo.saveAndFlush(profdisciplina);
	}
	
	
}
