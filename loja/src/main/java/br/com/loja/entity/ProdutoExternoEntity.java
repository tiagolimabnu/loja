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
@Table(name = "produto_externo")
public class ProdutoExternoEntity extends AppBaseEntity  implements Serializable {

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

	@Column(name = "preco_venda", nullable = false)
	private Double precoVenda;

	@Column(name = "data", nullable = true)
	private Date data = new Date();

	
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
		ProdutoExternoEntity other = (ProdutoExternoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
