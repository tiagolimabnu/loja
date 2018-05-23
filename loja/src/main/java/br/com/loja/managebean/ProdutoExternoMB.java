package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.ProdutoDTO;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.entity.UsuarioEntity;
import br.com.loja.facade.IProdutoExternoFacade;
import br.com.loja.facade.IProdutoFacade;
import br.com.loja.types.TipoCarros;

@ViewScoped
@Named
public class ProdutoExternoMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoDTO produto;

	private List<ProdutoDTO> produtos;

	private List<ProdutoDTO> produtosExternos;

	@Inject
	private ProdutoEntity produtointerno;

	@Inject
	private IProdutoExternoFacade produtoExternoFacade;

	@Inject
	private IProdutoFacade produtoFacadeInterno;

	@PostConstruct
	public void carregaProdutos() {
		recuperaProdutosExternos();
	}

	public void carregaProdutosExternoPorEstoque() {
		this.produtosExternos = produtoExternoFacade.recuperaProdutosExternoPorEstoque(this.produto);
	}

	public String recuperaProdutoInterno() {
		this.produtointerno = produtoFacadeInterno.buscaPorCodigoBarra(this.produto.getCodigoBarra());
		produto.setDescricao(produtointerno.getDescricao());
		produto.setPrecoVenda(produtointerno.getPctVenda());

		return null;
	}

	// tipos de usuarios
	public TipoCarros[] getTipos() {
		return TipoCarros.values();
	}

	public String adiciona() {
		produtoExternoFacade.adiciona(this.produto);
		this.produto = new ProdutoDTO();
		return null;
	}

	UsuarioEntity usuarioEntity = new UsuarioEntity();

	public void recuperaProdutosExternos() {
		this.produtos = produtoExternoFacade.recuperaProdutosExterno();
	}

	// ========================GETS SETS========================//

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public ProdutoEntity getProdutointerno() {
		return produtointerno;
	}

	public void setProdutointerno(ProdutoEntity produtointerno) {
		this.produtointerno = produtointerno;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public List<ProdutoDTO> getProdutosExternos() {
		return produtosExternos;
	}

	public void setProdutosExternos(List<ProdutoDTO> produtosExternos) {
		this.produtosExternos = produtosExternos;
	}

}
