package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.FornecedorEntity;
import br.com.loja.facade.IFornecedorFacade;
import br.com.loja.interfaces.ICrudMB;

@ViewScoped
@Named
public class FornecedorMB implements ICrudMB<FornecedorEntity>, Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private IFornecedorFacade fornecedorFacade;

	@Inject
	private FornecedorEntity fornecedor;

	private List<FornecedorEntity> fornecedores;

	@PostConstruct
	@Override
	public void inicializa() {
		recuperaFornecedores();
	}

	@Override
	public void grava() {
		fornecedorFacade.adiciona(this.fornecedor);
		recuperaFornecedores();
		novaIntancia();
	}

	public void recuperaFornecedores() {
		this.fornecedores = fornecedorFacade.recuperaTodos();
	}

	@Override
	public void remove() {
		this.fornecedorFacade.remove(this.fornecedor);
		recuperaFornecedores();
		novaIntancia();
	}
	
	public void update() {
		this.fornecedorFacade.update(this.fornecedor);
		recuperaFornecedores();
		novaIntancia();
	}
	

	@Override
	public void novaIntancia() {
		this.fornecedor = new FornecedorEntity();
	}

	public FornecedorEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorEntity fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<FornecedorEntity> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorEntity> fornecedores) {
		this.fornecedores = fornecedores;
	}

	// ===================== gets and sets =====================//

}
