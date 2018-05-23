package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.FornecedorEntity;

public interface IFornecedorFacade {

	public void adiciona(FornecedorEntity fornecedorEntityt);

	public void update(FornecedorEntity fornecedorEntityt);

	public void remove(FornecedorEntity fornecedorEntityt);

	public FornecedorEntity recuperaById(Long id);

	public List<FornecedorEntity> recuperaTodos();

}
