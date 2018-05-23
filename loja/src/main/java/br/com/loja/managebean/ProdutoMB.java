package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.FornecedorEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.facade.IAppFacade;
import br.com.loja.facade.IFornecedorFacade;
import br.com.loja.facade.IProdutoFacade;
import br.com.loja.interfaces.ICrudMB;

@ViewScoped
@Named
public class ProdutoMB implements ICrudMB<ProdutoEntity>, Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProdutoEntity produto;

	@Inject
	private IProdutoFacade produtoFacade;

	@Inject
	private IFornecedorFacade fornecedorFacade;

	@Inject
	private IAppFacade appFacade;

	private List<ProdutoEntity> produtos;

	private List<ProdutoEntity> produtosFilters;

	private List<FornecedorEntity> fornecedores;

	private List<CategoriaEntity> categorias;

	private String codigoBarraSelecionado;

	private Long quantidadeSelecionada;

	public void calcularPorcentagem() {
		Double pcompra = this.produto.getPrecoCompra();
		Double percentual = this.produto.getPctVenda();
		Double resultado = (pcompra * percentual) / 100;
		this.produto.setPrecoVenda(resultado);
	}

	public String recuperaProdutoPeloCodigoBarra() {
		this.produto = produtoFacade.buscaPorCodigoBarra(this.produto.getCodigoBarra());
		return null;
	}

	public void entradaProduto() {
		this.produto.setQuantidade(this.quantidadeSelecionada);
		produtoFacade.entradaProduto(produto);
		quantidadeSelecionada = null;
		novaIntancia();
	}

	public void saidaProduto() {
		this.produto.setQuantidade(this.quantidadeSelecionada);
		produtoFacade.saidaProduto(produto);
		quantidadeSelecionada = null;
		novaIntancia();
	}

	@PostConstruct
	@Override
	public void inicializa() {
		recuperaFornecedores();
		recuperaCategorias();
		recuperaProdutos();
	}

	public void recuperaFornecedores() {
		this.fornecedores = fornecedorFacade.recuperaTodos();
	}

	public void recuperaCategorias() {
		this.categorias = appFacade.recuperaTodos();
	}

	public void recuperaProdutos() {
		this.produtos = produtoFacade.recuperaTodos();
	}

	@Override
	public void grava() {
		produtoFacade.adiciona(this.produto);
		novaIntancia();
	}

	public void atualizaProduto() {
		produtoFacade.update(this.produto);
		recuperaProdutos();
		novaIntancia();
	}

	@Override
	public void remove() {
		produtoFacade.remove(this.produto);
		recuperaProdutos();
		novaIntancia();
	}

	@Override
	public void novaIntancia() {
		this.produto = new ProdutoEntity();
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public List<FornecedorEntity> getFornecedores() {
		return fornecedores;
	}

	public String getCodigoBarraSelecionado() {
		return codigoBarraSelecionado;
	}

	public void setCodigoBarraSelecionado(String codigoBarraSelecionado) {
		this.codigoBarraSelecionado = codigoBarraSelecionado;
	}

	public Long getQuantidadeSelecionada() {
		return quantidadeSelecionada;
	}

	public void setQuantidadeSelecionada(Long quantidadeSelecionada) {
		this.quantidadeSelecionada = quantidadeSelecionada;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}

	public List<ProdutoEntity> getProdutosFilters() {
		return produtosFilters;
	}

	public void setProdutosFilters(List<ProdutoEntity> produtosFilters) {
		this.produtosFilters = produtosFilters;
	}

}
