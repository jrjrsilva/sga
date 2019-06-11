package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.dto.ProfessorDTO;
import br.gov.ba.pm.sga.model.Professor;
import br.gov.ba.pm.sga.repository.ProfessorRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;

	public Professor find(Integer id) {
		return repo.findOne(id);
		/*Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
*/
	}
	
	public List<Professor> findAll() {
		return repo.findAll();
	}
	
	public Page<Professor> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
		
	public Professor insert(Professor obj) {
		obj.setCodProfessor(null);
		return repo.save(obj);
	}
	
	public Professor update(Professor obj) {
		Professor newObj = find(obj.getCodProfessor());
		updateData(newObj,obj);
		return repo.save(obj);
	}
	
	public Professor fromDTO(ProfessorDTO objDTO) {
		return new Professor(objDTO.getCodProfessor(),objDTO.getProfessorNome(),objDTO.getApelido(),objDTO.getDataNasc(),objDTO.getCpf(),objDTO.getRg(),objDTO.getExpedidor());
	}
	
	private void updateData(Professor newObj, Professor obj) {
		newObj.setCodProfessor(obj.getCodProfessor());
		newObj.setProfessorNome(obj.getProfessorNome());
		newObj.setApelido(obj.getApelido());
		newObj.setDataNasc(obj.getDataNasc());
		newObj.setCpf(obj.getCpf());
		newObj.setRg(obj.getRg());
		newObj.setExpedidor(obj.getExpedidor());
	}
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um professor que possui registros");
		}
	}

	public void save(Professor professor) {
		this.repo.saveAndFlush(professor);
	}

	public Professor findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.repo.findByEmail(email);
	}
	
	
}
