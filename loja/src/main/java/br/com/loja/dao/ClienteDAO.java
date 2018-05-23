package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.loja.entity.ClienteEntity;
import br.com.loja.interfaces.IAssinaturaDAO;

@ApplicationScoped
public class ClienteDAO implements Serializable, IAssinaturaDAO<ClienteEntity>{

	private static final long serialVersionUID = 7684757931282924292L;

	private Dao<ClienteEntity> dao = new Dao<ClienteEntity>(ClienteEntity.class);

	@Override
	public void adiciona(ClienteEntity t) {
		dao.adiciona(t);
	}

	@Override
	public void update(ClienteEntity t) {
		dao.update(t);
	}

	@Override
	public void remove(ClienteEntity t) {
		dao.remove(t);
	}

	@Override
	public ClienteEntity recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	public List<ClienteEntity> recuperaItensOrdenado() {
		return dao.recuperaItensOrdenado("nome");
	}
	
	public List<ClienteEntity> recuperaTodosClientes() {
		return dao.recuperaTodosClientes();
	}
	
	@Override
	public List<ClienteEntity> recuperaTodos() {
		return dao.getAll();
	}
	
}
