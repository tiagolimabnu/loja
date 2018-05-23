package br.com.loja.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.loja.comum.AppBaseEntity;
import br.com.loja.types.TipoUsuario;

@Entity
@Table(name = "usuario")
public class UsuarioEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 4981050238114737389L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;

	@Column(name = "login", length = 60, nullable = false)
	private String login;

	@Column(name = "senha", length = 100, nullable = false)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "titpo_usuario", length = 60, nullable = false)
	private TipoUsuario tipoUsuario;

	@OneToMany(targetEntity = PermissoesEntity.class, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<PermissoesEntity> permissoes;

	public UsuarioEntity() {
	}

	public UsuarioEntity(Long id, String nome, String login, String senha, TipoUsuario tipoUsuario,
			List<PermissoesEntity> permissoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.permissoes = permissoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<PermissoesEntity> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissoesEntity> permissoes) {
		this.permissoes = permissoes;
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
