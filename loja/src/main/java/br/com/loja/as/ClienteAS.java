package br.com.loja.as;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.entity.ClienteEntity;
import br.com.loja.interfaces.IAssinaturaBO;

@ApplicationScoped
public class ClienteAS implements Serializable, IAssinaturaBO<ClienteEntity> {

	private static final long serialVersionUID = 6129618031504662884L;

	@Inject
	private ClienteDAO clienteDAO;

	@Override
	public void adiciona(ClienteEntity t) {
		clienteDAO.adiciona(t);
	}

	@Override
	public void update(ClienteEntity t) {
		clienteDAO.update(t);
	}

	@Override
	public void remove(ClienteEntity t) {
		clienteDAO.remove(t);
	}

	@Override
	public ClienteEntity recuperaById(Long id) {
		return clienteDAO.recuperaById(id);
	}
	
	@Override
	public List<ClienteEntity> recuperaTodos() {
		return clienteDAO.recuperaTodosClientes();
	}

}
