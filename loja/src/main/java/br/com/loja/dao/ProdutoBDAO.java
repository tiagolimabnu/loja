package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityB;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoBDAO implements Serializable, IAssinaturaDAO<ProdutoEntityB> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityB> dao = new Dao<ProdutoEntityB>(ProdutoEntityB.class);

	@Override
	public void adiciona(ProdutoEntityB t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntityB t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityB t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityB recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityB> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityB> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityB> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

 

}
