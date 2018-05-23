package br.com.loja.facade;

import java.util.List;

import br.com.loja.entity.ClienteEntity;

public interface IClienteFacade {

	public void adiciona(ClienteEntity cliente);

	public void update(ClienteEntity cliente);

	public void remove(ClienteEntity cliente);

	public ClienteEntity recuperaById(Long id);

	public List<ClienteEntity> recuperaTodos();

}
