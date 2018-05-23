package br.com.loja.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.loja.comum.AppBaseEntity;
import br.com.loja.types.TipoPermissao;

@Entity
@Table(name = "permissoes")
public class PermissoesEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 4959501795689851367L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tela", length = 60, nullable = true)
	private String tela;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_permissao", length = 60, nullable = true)
	private TipoPermissao tipoPermissao;

	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public PermissoesEntity() {
	}

	public PermissoesEntity(Long id, String tela, TipoPermissao tipoPermissao, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.tela = tela;
		this.tipoPermissao = tipoPermissao;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public TipoPermissao getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
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
		PermissoesEntity other = (PermissoesEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
