package br.com.loja.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.PermissoesEntity;

@RequestScoped
@Named
public class PermissaoMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PermissoesEntity permissoa;

	@Inject
	private PopulaPermissao facade;

	public PermissoesEntity getPermisso() {
		return permissoa;
	}

	public void setPermisso(PermissoesEntity permissoa) {
		this.permissoa = permissoa;
	}

	@PostConstruct
	public void carregaPermissao() {
		this.permissoa = facade.permissao();
	}

	public PermissoesEntity getPermissoa() {
		return permissoa;
	}

	public void setPermissoa(PermissoesEntity permissoa) {
		this.permissoa = permissoa;
	}

}
