package br.edu.ifpb.esperanca.daw2.RecursosHidricos.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.edu.ifpb.esperanca.daw2.RecursosHidricos.DAO.CultivoDAO;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.DAO.UsuarioDAO;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities.Cultivo;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities.Usuario;
import br.edu.ifpb.esperanca.daw2.util.TransacionalCdi;

@ApplicationScoped
public class CultivoService implements Serializable, Service<Cultivo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;
	
	@Inject
	private CultivoDAO cultiDAO;
	

	@TransacionalCdi
	public void save(Cultivo culti) {
		cultiDAO.save(culti);
	}

	@TransacionalCdi
	public void update(Cultivo culti)  {
		cultiDAO.update(culti);
	}

	@TransacionalCdi
	public void remove(Cultivo entidade) {
		cultiDAO.remove(entidade);
	}

	public Cultivo getByID(long cultId)  {
			return cultiDAO.getByID(cultId);
	}

	public List<Cultivo> getAll() {
			return cultiDAO.getAll();
	}
		
}