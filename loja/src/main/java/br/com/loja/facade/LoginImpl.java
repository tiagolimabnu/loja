package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.bo.UsuarioBO;
import br.com.loja.entity.UsuarioEntity;

@ApplicationScoped
public class LoginImpl implements Serializable, ILoginFacade {

	private static final long serialVersionUID = 4024055921733026871L;

	@Inject
	private UsuarioBO usuarioBO;

	@Override
	public UsuarioEntity logar(UsuarioEntity usuario) {
		return usuarioBO.logar(usuario);
	}

	@Override
	public void adiciona(UsuarioEntity usuario) {
		usuarioBO.adiciona(usuario);
	}

	@Override
	public void update(UsuarioEntity usuario) {
		usuarioBO.update(usuario);
	}

	@Override
	public void remove(UsuarioEntity usuario) {
		usuarioBO.remove(usuario);
	}

	@Override
	public UsuarioEntity recuperaById(Long id) {
		return usuarioBO.recuperaById(id);
	}

	@Override
	public List<UsuarioEntity> recuperaTodos() {
		return usuarioBO.recuperaTodos();
	}

	 
}
