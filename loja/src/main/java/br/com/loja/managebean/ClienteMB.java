package br.com.loja.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.facade.IClienteFacade;
import br.com.loja.interfaces.ICrudMB;

@ViewScoped
@Named
public class ClienteMB implements ICrudMB<ClienteEntity>, Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ClienteEntity cliente;

	@Inject
	private IClienteFacade clienteFacade;

	private List<ClienteEntity> clientes;
	
	private String valor;

	public String recuperaCliente(ClienteEntity cliente) {
		this.cliente = cliente;
		return null;
	}

	@Override
	@PostConstruct
	public void inicializa() {
		recuperaTodosClientes();
	}

	@Override
	public void grava() {
		clienteFacade.adiciona(this.cliente);
		novaIntancia();
		recuperaTodosClientes();
	}

	@Override
	public void remove() {
		this.clienteFacade.remove(this.cliente);
		recuperaTodosClientes();
		novaIntancia();
	}

	public void recuperaTodosClientes() {
		this.clientes = clienteFacade.recuperaTodos();
	}

	public String atualiza() {
		clienteFacade.update(this.cliente);
		novaIntancia();
		recuperaTodosClientes();
		return null;
	}

	@Override
	public void novaIntancia() {
		this.cliente = new ClienteEntity();
	}

	// ===================== gets and sets =====================//

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<ClienteEntity> getClientes() {
		return clientes;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	

}
