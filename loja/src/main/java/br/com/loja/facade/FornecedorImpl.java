package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.bo.FornecedorBO;
import br.com.loja.entity.FornecedorEntity;

@ApplicationScoped
public class FornecedorImpl implements Serializable, IFornecedorFacade{

	private static final long serialVersionUID = 6351645955633350912L;
	
	@Inject
	private FornecedorBO fornecedorBO;
	
	@Override
	public void adiciona(FornecedorEntity t) {
		fornecedorBO.adiciona(t);
	}

	@Override
	public void update(FornecedorEntity t) {
		fornecedorBO.update(t);
	}

	@Override
	public void remove(FornecedorEntity t) {
		fornecedorBO.remove(t);
	}

	@Override
	public FornecedorEntity recuperaById(Long id) {
		return fornecedorBO.recuperaById(id);
	}

	@Override
	public List<FornecedorEntity> recuperaTodos() {
		return fornecedorBO.recuperaTodos();
	}

}
