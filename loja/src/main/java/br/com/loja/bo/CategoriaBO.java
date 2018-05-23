package br.com.loja.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.entity.CategoriaEntity;

@ApplicationScoped
public class CategoriaBO implements Serializable {

	private static final long serialVersionUID = 3859369554332546009L;

	@Inject
	private CategoriaDAO categoriaDAO;

	public void adiciona(CategoriaEntity t) {
		categoriaDAO.adiciona(t);
	}

	public void update(CategoriaEntity t) {
		categoriaDAO.update(t);
	}

	public void remove(CategoriaEntity t) {
		categoriaDAO.remove(t);
	}

	public CategoriaEntity recuperaById(Long id) {
		return categoriaDAO.recuperaById(id);
	}

	public List<CategoriaEntity> recuperaTodos() {
		return categoriaDAO.recuperaTodos();
	}

}
