package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.bo.ProdutoBO;
import br.com.loja.entity.ProdutoEntity;

@ApplicationScoped
public class ProdutoImpl implements Serializable, IProdutoFacade {

	private static final long serialVersionUID = 4024055921733026871L;

	@Inject
	private ProdutoBO produtoBO;

	@Override
	public ProdutoEntity buscaPorCodigoBarra(String codigo) {
		return produtoBO.buscaPorCodigoBarra(codigo);
	}

	@Override
	public void entradaProduto(ProdutoEntity produto) {
		produtoBO.entradaProduto(produto);
	}

	@Override
	public void adiciona(ProdutoEntity produto) {
		if (produto != null) {
			produtoBO.adiciona(produto);
			// FacesUtil.addInfoMessage("Produto "+produto.getDescricao()+" gravado com
			// sucesso!");
		} else {
			// FacesUtil.addErrorMessage("Erro ao gravar o Produto");
		}

	}

	@Override
	public void update(ProdutoEntity produto) {
		produtoBO.update(produto);
	}

	@Override
	public void remove(ProdutoEntity produto) {
		produtoBO.remove(produto);
	}

	@Override
	public ProdutoEntity recuperaById(Long id) {
		return produtoBO.recuperaById(id);
	}

	@Override
	public List<ProdutoEntity> recuperaTodos() {
		return produtoBO.recuperaTodos();
	}

	@Override
	public void recuperaProdutoDetalhe(String descrica) {

	}

	@Override
	public void saidaProduto(ProdutoEntity produto) {
		produtoBO.saidaProduto(produto);
	}

}
