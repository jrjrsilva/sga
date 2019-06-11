package br.gov.ba.pm.sga.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.gov.ba.pm.sga.model.Usuario;
import br.gov.ba.pm.sga.repository.UsuarioRepository;
import br.gov.ba.pm.sga.service.exception.DataIntegrityException;
import br.gov.ba.pm.sga.service.exception.ObjectNotFoundException;;



@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		/*UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado!");
		}*/
		
		return  repo.findOne(id);
		/*return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
*/
	}
	
	public Usuario findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Page<Usuario> findAll(int page, int count) {
		Pageable pages = new PageRequest(page, count);
		return repo.findAll(pages);
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
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
			throw new DataIntegrityException("Não é possível excluir um Usuario que possui registros");
		}
	}
	
	public Usuario createOrUpdate(Usuario usuario) {
		
		return repo.save(usuario);
	}
}
