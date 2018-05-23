package br.com.loja.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.loja.types.TipoCarros;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = -2384039757663064651L;

	private Long id;
	private String codigoBarra;
	private String descricao;
	private Long quantidade;
	private Double precoVenda;
	private Date data = new Date();
	private TipoCarros tipo;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id, String codigoBarra, String descricao, Long quantidade, Double precoVenda, Date data,
			TipoCarros tipo) {
		super();
		this.id = id;
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.data = data;
		this.tipo = tipo;
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

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoCarros getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarros tipo) {
		this.tipo = tipo;
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
		ProdutoDTO other = (ProdutoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
