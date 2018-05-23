package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.bo.CategoriaBO;
import br.com.loja.entity.CategoriaEntity;

@ApplicationScoped
public class CategoriaImpl implements Serializable, IAppFacade {

	private static final long serialVersionUID = 4024055921733026871L;

	@Inject
	private CategoriaBO categoriaBO;

	@Override
	public void adiciona(CategoriaEntity categoria) {
		categoriaBO.adiciona(categoria);
	}

	@Override
	public void update(CategoriaEntity categoria) {
		categoriaBO.update(categoria);
	}

	@Override
	public void remove(CategoriaEntity categoria) {
		categoriaBO.remove(categoria);
	}

	@Override
	public CategoriaEntity recuperaById(Long id) {
		return categoriaBO.recuperaById(id);
	}

	@Override
	public List<CategoriaEntity> recuperaTodos() {
		return categoriaBO.recuperaTodos();
	}

}
