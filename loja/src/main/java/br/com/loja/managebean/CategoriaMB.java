package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.CategoriaEntity;
import br.com.loja.facade.IAppFacade;

@ViewScoped
@Named
public class CategoriaMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private IAppFacade categoriaFacade;
	
	@Inject
	private CategoriaEntity categoria;
	
	private List<CategoriaEntity> categorias;
	
	@PostConstruct
	public void carregarCategorias() {
		categorias = categoriaFacade.recuperaTodos();
	}
	
	public void grava() {
		categoriaFacade.adiciona(this.categoria);
		carregarCategorias();
		novaIntancia();
	}
	
	public void novaIntancia() {
		this.categoria = new CategoriaEntity();
	}

	public void atualizaCategoria() {
		categoriaFacade.update(this.categoria);
		carregarCategorias();
		novaIntancia();
	}

	public void remove() {
		categoriaFacade.remove(this.categoria);
		novaIntancia();
		carregarCategorias();
		
	}
	
	//=========================GETS SETS=========================//
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}
	
}
