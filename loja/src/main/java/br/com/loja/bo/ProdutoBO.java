package br.com.loja.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.interfaces.IAssinaturaBO;
import br.com.loja.util.jsf.FacesUtil;

@ApplicationScoped
public class ProdutoBO implements Serializable, IAssinaturaBO<ProdutoEntity> {

	private static final long serialVersionUID = 3859369554332546009L;

	@Inject
	private ProdutoDAO produtoDAO;

	public ProdutoEntity buscaPorCodigoBarra(String codigo) {
		ProdutoEntity produto = produtoDAO.buscaPorCodigoBarra(codigo);
		if (produto !=null) {
			return produto;
		}
		FacesUtil.addErrorMessage("Produto nao encontrado");
		return null;
	}
	
	public void saidaProduto(ProdutoEntity produto) {
		produtoDAO.saidaProduto(produto);
	}
	
	public void entradaProduto(ProdutoEntity produto) {
		produtoDAO.entradaProduto(produto);
	}

	@Override
	public void adiciona(ProdutoEntity t) {
		produtoDAO.adiciona(t);
	}

	@Override
	public void update(ProdutoEntity t) {
		produtoDAO.update(t);
	}

	@Override
	public void remove(ProdutoEntity t) {
		produtoDAO.remove(t);
	}

	@Override
	public ProdutoEntity recuperaById(Long id) {
		return produtoDAO.recuperaById(id);
	}

	@Override
	public List<ProdutoEntity> recuperaTodos() {
		return produtoDAO.recuperaTodos();
	}

}
