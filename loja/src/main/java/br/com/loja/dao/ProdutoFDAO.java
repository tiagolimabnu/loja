package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityF;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoFDAO implements Serializable, IAssinaturaDAO<ProdutoEntityF> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityF> dao = new Dao<ProdutoEntityF>(ProdutoEntityF.class);

	@Override
	public void adiciona(ProdutoEntityF t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntityF t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityF t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityF recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityF> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityF> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityF> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	 
}
