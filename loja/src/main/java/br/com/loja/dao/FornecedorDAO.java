package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.FornecedorEntity;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class FornecedorDAO implements Serializable, IAssinaturaDAO<FornecedorEntity> {

	private static final long serialVersionUID = -5025515727647001849L;
	
	private Dao<FornecedorEntity> dao = new Dao<FornecedorEntity>(FornecedorEntity.class);

	
	@Override
	public void adiciona(FornecedorEntity t) {
		dao.adiciona(t);
	}

	@Override
	public void update(FornecedorEntity t) {
		dao.update(t);
	}

	@Override
	public void remove(FornecedorEntity t) {
		dao.remove(t);
	}

	@Override
	public FornecedorEntity recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<FornecedorEntity> recuperaTodos() {
		return dao.recuperaItensOrdenado("nome");
	}
	
}






