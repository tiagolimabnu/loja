package br.com.loja.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.loja.comum.AppBaseEntity;

@Entity
@Table(name = "produto")
public class ProdutoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -8940477359999431984L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codigo_barra", unique = true, nullable = false)
	private String codigoBarra;

	@Column(name = "codigo", unique = true, length=100, nullable = false)
	private String codigo;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "quantidade", nullable = false)
	private Long quantidade;

	@Column(name = "quantidade_minima", nullable = false)
	private Long quantidadeMinima;

	@Column(name = "quantidade_maxima", nullable = false)
	private Long quantidadeMaxima;

	@Column(name = "preco_compra", nullable = false)
	private Double precoCompra;

	@Column(name = "pct_venda", nullable = true)
	private Double pctVenda;

	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;

	@Column(name = "data", nullable = true)
	private Date data = new Date();

	@ManyToOne(targetEntity = FornecedorEntity.class, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "fornecedor_id", referencedColumnName = "id") })
	private FornecedorEntity fornecedor;

	@ManyToOne(targetEntity = CategoriaEntity.class, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "categoria_id", referencedColumnName = "id") })
	private CategoriaEntity categoria;

	public ProdutoEntity() {
	}

	public ProdutoEntity(Long id, String codigoBarra, String descricao, Long quantidade, Long quantidadeMinima,
			Long quantidadeMaxima, Double precoCompra, Double pctVenda, Double precoVenda, Date data,
			FornecedorEntity fornecedor, CategoriaEntity categoria, String codigo) {
		super();
		this.id = id;
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeMaxima = quantidadeMaxima;
		this.precoCompra = precoCompra;
		this.pctVenda = pctVenda;
		this.precoVenda = precoVenda;
		this.data = data;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Long quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public Long getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(Long quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getPctVenda() {
		return pctVenda;
	}

	public void setPctVenda(Double pctVenda) {
		this.pctVenda = pctVenda;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public FornecedorEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
