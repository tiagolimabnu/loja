package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.as.ProdutoExternoAS;
import br.com.loja.entity.ProdutoDTO;
import br.com.loja.util.jsf.FacesUtil;

@ApplicationScoped
public class ProdutoExternoImpl implements Serializable, IProdutoExternoFacade {

	private static final long serialVersionUID = 4024055921733026871L;

	@Inject
	private ProdutoExternoAS produtoExternoAS;

	@Override
	public List<ProdutoDTO> recuperaProdutosExterno() {
		return produtoExternoAS.recuperaProdutoExternos();
	}
	
	@Override
	public void adiciona(ProdutoDTO produto) {
		try {
			produtoExternoAS.cadatrarProdutoExterno(produto);

		} catch (Exception e) {
			if (e.getCause().toString().contains("could not execute statement")) {
				FacesUtil.addErrorMessage(produto.getDescricao()+" ja esta  cadastrado no estoque : "+produto.getTipo().getLabel());
			}
			return;
		}
	}

	public List<ProdutoDTO> recuperaProdutosExternoPorEstoque(ProdutoDTO produto) {
		return produtoExternoAS.recuperaProdutosExternoPorEstoque(produto);
	}

	
}
