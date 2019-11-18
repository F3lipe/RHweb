package br.edu.ifpb.esperanca.daw2.RecursosHidricos.Bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities.Cultivo;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.services.CultivoService;

@Named
@SessionScoped
public class CultivoBean implements Serializable {
	
	@Inject
	private CultivoService service;
	protected Cultivo entidade;
	protected Collection<Cultivo> entidades;

	public CultivoBean() {

	}

	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}
	
	public void remove(Cultivo entidade) {
		getService().remove(entidade);
		limpar();
	}

	
	
	public Cultivo getEntidade() {
		return entidade;
	}

	public void setEntidade(Cultivo entidade) {
		this.entidade = entidade;
	}

	public Collection<Cultivo> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Cultivo> entidades) {
		this.entidades = entidades;
	}

	public void setService(CultivoService service) {
		this.service = service;
	}
	
	public void save() {
		getService().save(entidade);
		limpar();
	}
	
	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	private void limpar() {
		entidades = getService().getAll();
		entidade = newEntidade();
	}
	protected Cultivo newEntidade() {
		return new Cultivo();
	}

	private CultivoService getService() {
		return service;
	}

}
