package br.com.loja.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.loja.comum.AppBaseEntity;

@Entity
@Table(name = "produto_a")
public class ProdutoEntityA extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -8940477359999431984L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "codigo_barra", unique = true, nullable = false)
	private String codigoBarra;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "quantidade", nullable = false)
	private Long quantidade;

	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;

	@Column(name = "data", nullable = true)
	private Date data;

	public ProdutoEntityA() {
	}

	public ProdutoEntityA(Long id, String codigoBarra, String descricao, Long quantidade, Double precoVenda,
			Date data) {
		super();
		this.id = id;
		this.codigoBarra = codigoBarra;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.data = data;
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
		ProdutoEntityA other = (ProdutoEntityA) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
