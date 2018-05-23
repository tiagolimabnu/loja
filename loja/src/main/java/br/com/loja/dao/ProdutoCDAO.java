package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityC;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoCDAO implements Serializable, IAssinaturaDAO<ProdutoEntityC> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityC> dao = new Dao<ProdutoEntityC>(ProdutoEntityC.class);

	@Override
	public void adiciona(ProdutoEntityC t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntityC t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityC t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityC recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityC> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityC> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityC> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	 
}
