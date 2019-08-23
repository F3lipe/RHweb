package br.edu.ifpb.esperanca.daw2.RecursosHidricos.services;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.edu.ifpb.esperanca.daw2.RecursosHidricos.DAO.UsuarioDAO;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities.Usuario;
import br.edu.ifpb.esperanca.daw2.util.TransacionalCdi;

@ApplicationScoped
public class UsuarioService implements Serializable, Service<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;
	
	@Inject
	private UsuarioDAO userDAO;
	

	@TransacionalCdi
	public void save(Usuario user) {
		userDAO.save(user);
	}

	@TransacionalCdi
	public void update(Usuario user)  {
			userDAO.update(user);
	}

	@TransacionalCdi
	public void remove(Usuario user) {
		userDAO.remove(user);
	}

	public Usuario getByID(long userId)  {
			return userDAO.getByID(userId);
	}

	public List<Usuario> getAll() {
			return userDAO.getAll();
	}
		
}
