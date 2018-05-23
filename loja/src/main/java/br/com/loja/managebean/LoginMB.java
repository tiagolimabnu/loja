package br.com.loja.managebean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.UsuarioEntity;
import br.com.loja.facade.ILoginFacade;

@ViewScoped
@Named
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;


	@Inject
	private UsuarioEntity usuario;
	
	@Inject
	private ILoginFacade loginFacade;
	
	
	
	public void logar() {
		loginFacade.logar(this.usuario);
	}

	
	//=========================GETS SETS=========================//
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}
