package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.ProdutoEntity;

public interface IProdutoFacade {

	public void adiciona(ProdutoEntity produto);

	public void update(ProdutoEntity produto);

	public void remove(ProdutoEntity produto);

	public ProdutoEntity recuperaById(Long id);

	public List<ProdutoEntity> recuperaTodos();
	
	public void recuperaProdutoDetalhe(String descrica);
	
	public ProdutoEntity buscaPorCodigoBarra(String codigo);
	
	public void entradaProduto(ProdutoEntity produto);
	
	public void saidaProduto(ProdutoEntity produto) ;
	

}
