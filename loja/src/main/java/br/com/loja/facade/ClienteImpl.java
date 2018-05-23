package br.com.loja.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.as.ClienteAS;
import br.com.loja.entity.ClienteEntity;

@ApplicationScoped
public class ClienteImpl implements Serializable, IClienteFacade {

	private static final long serialVersionUID = 4024055921733026871L;

	@Inject
	private ClienteAS clienteAS;

	@Override
	public void adiciona(ClienteEntity cliente) {
		clienteAS.adiciona(cliente);
	}

	@Override
	public void update(ClienteEntity cliente) {
		clienteAS.update(cliente);
	}

	@Override
	public void remove(ClienteEntity cliente) {
		clienteAS.remove(cliente);
	}

	@Override
	public ClienteEntity recuperaById(Long id) {
		return clienteAS.recuperaById(id);
	}

	@Override
	public List<ClienteEntity> recuperaTodos() {
		return clienteAS.recuperaTodos();
	}

}
