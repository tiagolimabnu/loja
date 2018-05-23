package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ProdutoDAO implements Serializable, IAssinaturaDAO<ProdutoEntity> {

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ProdutoEntity> dao = new Dao<ProdutoEntity>(ProdutoEntity.class);

	@Override
	public void adiciona(ProdutoEntity t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ProdutoEntity t) {
		dao.update(t);
	}

	@Override
	public void remove(ProdutoEntity t) {
		dao.remove(t);
	}

	@Override
	public ProdutoEntity recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<ProdutoEntity> recuperaTodos() {
		return dao.getAll();
	}

	public List<ProdutoEntity> recuperaItem(String valor, String paramentro) {
		return dao.recuperaItem(valor, paramentro);
	}

	public List<ProdutoEntity> recuperaPelaDescricao(String value) {
		return dao.recuperaPorDescricao(value);
	}

	public void entradaProduto(ProdutoEntity produto) {
		dao.entradaProduto(produto);
	}

	public void saidaProduto(ProdutoEntity produto) {
		dao.saidaProduto(produto);
	}
	
	public List<ProdutoEntity> recuperaItensOrdenado() {
		return dao.recuperaItensOrdenado("descricao");
	}
	
	

	public ProdutoEntity buscaPorCodigoBarra(String codigo) {
		return dao.buscaPorCodigoBarra(codigo);
	}

}
