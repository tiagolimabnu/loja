package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.UsuarioEntity;

public interface ILoginFacade {
	
	public UsuarioEntity logar(UsuarioEntity usuario);
	
	public void adiciona(UsuarioEntity usuario);

	public void update(UsuarioEntity usuario);

	public void remove(UsuarioEntity usuario);

	public UsuarioEntity recuperaById(Long id);

	public List<UsuarioEntity> recuperaTodos();
	
	
	 
}
