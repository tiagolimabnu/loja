package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityE;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoEDAO implements Serializable, IAssinaturaDAO<ProdutoEntityE> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityE> dao = new Dao<ProdutoEntityE>(ProdutoEntityE.class);

	@Override
	public void adiciona(ProdutoEntityE t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntityE t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityE t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityE recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityE> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityE> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityE> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	 
}
