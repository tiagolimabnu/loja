package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ProdutoEntityA;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoADAO implements Serializable, IAssinaturaDAO<ProdutoEntityA> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntityA> dao = new Dao<ProdutoEntityA>(ProdutoEntityA.class);

	@Override
	public void adiciona(ProdutoEntityA t) {
		dao.adiciona(t);
	}
	
	public void entradaProduto(Long novaquantidade, Long produtoid) {
		dao.entradaProdutoGenerica(novaquantidade, produtoid);
	}

	@Override
	public void update(ProdutoEntityA t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntityA t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntityA recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntityA> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntityA> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntityA> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	 
}
