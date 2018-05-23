package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityD;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoDDAO implements Serializable, IAssinaturaDAO<ProdutoEntityD> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityD> dao = new Dao<ProdutoEntityD>(ProdutoEntityD.class);

	@Override
	public void adiciona(ProdutoEntityD t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntityD t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityD t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityD recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityD> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityD> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityD> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	 
}
