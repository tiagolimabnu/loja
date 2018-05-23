package br.com.loja.comum;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -8041929115797201847L;

	@Column(name = "usu_ulti_alteracao", length = 60, nullable = true)
	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ulti_alteracao", nullable = true)
	private Date dataUltimaAlteracao;

	public AppBaseEntity() {
	}

	public AppBaseEntity(String usuarioUltimaAlteracao, Date dataUltimaAlteracao) {
		super();
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

}
