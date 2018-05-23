package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.entity.FornecedorEntity;
import br.com.loja.facade.IClienteFacade;
import br.com.loja.facade.IFornecedorFacade;

@RequestScoped
@Named
public class FornecedorConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;


	@Inject
	private IFornecedorFacade fornecedorFacade;

	
	

}
