package br.gov.ba.pm.sga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Nota;
import br.gov.ba.pm.sga.model.Turma;
import br.gov.ba.pm.sga.repository.NotaRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;

@Service
public class NotaService {

	@Autowired
	private NotaRepository repo;

	public Nota find(Integer id) {
		return repo.findOne(id);
		/*Optional<Nota> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Nota.class.getName()));
*/
	}
	
	public Nota insert(Nota obj) {
		obj.setCodNota(null);
		return repo.save(obj);
	}
	
	public Nota update(Nota obj, Integer seletor) {
		Nota newObj = find(obj.getCodNota());
		switch (seletor) {
		case 1:
			updateDataVc1(newObj,obj);
			break;
		case 2:
			updateDataVc2(newObj,obj);
			break;

		default:
			break;
		}
		
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Nota que possui registros");
		}
	}
	
	public List<Nota> findAll() {
		return repo.findAll();
	}
	
	
	public Nota findByAlunoAndDisciplinaAndTurma(Integer aluno, Integer disciplina,Integer turma){	 
		 return repo.findByAlunoAndDisciplinaAndTurma(aluno,disciplina,turma);
	}
	
	public List<Nota> findByDisciplinaAndTurma(Integer disciplina,Integer turma){	 
		 return repo.findByDisciplinaAndTurma(disciplina,turma);
	}
	
	
	public Page<Nota> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		 PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction),
				 orderBy);
		 return repo.findAll(pageRequest);
	}
		
	public List<Nota> findByTurmaDisciplinaSemestre(Integer turma,Integer disciplina,String semestre){
		
		 return repo.findByTurmaDisciplinaSemestre(turma,disciplina,semestre);
	}
	
	private void updateDataVc1(Nota newObj, Nota obj) {
		newObj.setvC11Sem(obj.getvC11Sem());
		newObj.setvC21Sem(obj.getvC21Sem());
		newObj.setvF1Sem(obj.getvF1Sem());
		newObj.setRec1Sem(obj.getRec1Sem());
		newObj.setCons1Sem(obj.getCons1Sem());
		newObj.setMedPar1Sem(calcMediaP1(obj));
	}
	
	private void updateDataVc2(Nota newObj, Nota obj) {
		newObj.setvC12Sem(obj.getvC12Sem());
		newObj.setvC22Sem(obj.getvC22Sem());
		newObj.setvF2Sem(obj.getvF2Sem());
		newObj.setRec2Sem(obj.getRec2Sem());
		newObj.setCons2Sem(obj.getCons2Sem());
		newObj.setMedPar2Sem(calcMediaP2(obj));
	}
	
	private Float calcMediaP1(Nota obj) {
		Float retorno = (float) 0;
		if(obj.getvC11Sem() > 0 && obj.getvC21Sem() > 0 && obj.getvF1Sem() > 0) {
			retorno =(Float) ((obj.getvC11Sem()+obj.getvC21Sem()+ obj.getvF1Sem()) /3);
		} else
		if(obj.getvC11Sem() > 0 && obj.getvF1Sem() > 0) {
			retorno =(Float) ((obj.getvC11Sem()+ obj.getvF1Sem()) /2);
		}
				
		return retorno;
	}
	
	private Float calcMediaFimSem(Nota obj) {
		Float retorno = (float) 0;
		if(obj.getSemestre().equals("1")) {
			if(obj.getMedPar1Sem() >= 5) {
				retorno = obj.getMedPar1Sem();
			}else if(obj.getRec1Sem() > 0  || obj.getCons1Sem() > 0) {
				retorno = new Float(5);
			}
		}else if (obj.getSemestre().equals("2")) {
			if(obj.getMedPar2Sem() >= 5) {
				retorno = obj.getMedPar2Sem();
			}else if(obj.getRec2Sem() > 0 || obj.getCons2Sem() > 0) {
				retorno = new Float(5);
			}
		}			
		return retorno;
	}
	
	
	
	private Float calcMediaP2(Nota obj) {
		Float retorno = (float) 0;
		if(obj.getvC12Sem() > 0 && obj.getvC22Sem() > 0 && obj.getvF2Sem() > 0) {
			retorno =(Float) ((obj.getvC12Sem()+obj.getvC22Sem()+ obj.getvF2Sem()) /3);
		} else
		if(obj.getvC12Sem() > 0 && obj.getvF2Sem() > 0) {
			retorno =(Float) ((obj.getvC12Sem()+ obj.getvF2Sem()) /2);
		}
				
		return retorno;
	}
	
}
