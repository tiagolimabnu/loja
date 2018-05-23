package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.ProdutoDTO;

public interface IProdutoExternoFacade {

	public void adiciona(ProdutoDTO produto);
	
	public List<ProdutoDTO> recuperaProdutosExterno();

	public List<ProdutoDTO> recuperaProdutosExternoPorEstoque(ProdutoDTO produto);
		

}
