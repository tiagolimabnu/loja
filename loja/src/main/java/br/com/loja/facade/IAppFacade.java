package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.CategoriaEntity;

public interface IAppFacade {
	
	public void adiciona(CategoriaEntity categoria);

	public void update(CategoriaEntity categoria);

	public void remove(CategoriaEntity categoria);

	public CategoriaEntity recuperaById(Long id);

	public List<CategoriaEntity> recuperaTodos();
	

}
