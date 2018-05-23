package br.com.loja.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.dao.FornecedorDAO;
import br.com.loja.entity.FornecedorEntity;
import br.com.loja.interfaces.IAssinaturaBO;

@ApplicationScoped
public class FornecedorBO implements Serializable, IAssinaturaBO<FornecedorEntity> {

	private static final long serialVersionUID = 6129618031504662884L;

	@Inject
	private FornecedorDAO fornecedorDAO;

	@Override
	public void adiciona(FornecedorEntity t) {
		fornecedorDAO.adiciona(t);
	}

	@Override
	public void update(FornecedorEntity t) {
		fornecedorDAO.update(t);
	}

	@Override
	public void remove(FornecedorEntity t) {
		fornecedorDAO.remove(t);
	}

	@Override
	public FornecedorEntity recuperaById(Long id) {
		return fornecedorDAO.recuperaById(id);
	}

	@Override
	public List<FornecedorEntity> recuperaTodos() {
		return fornecedorDAO.recuperaTodos();
	}

}
