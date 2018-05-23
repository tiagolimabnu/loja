package br.com.loja.dao;

import java.io.Serializable;
import java.util.List;

import br.com.loja.entity.UsuarioEntity;
import br.com.loja.interfaces.IAssinaturaDAO;

public class UsuarioDAO implements Serializable, IAssinaturaDAO<UsuarioEntity> {

	private static final long serialVersionUID = 1830911706044903686L;
	
	private Dao<UsuarioEntity> dao = new Dao<UsuarioEntity>(UsuarioEntity.class);

	@Override
	public void adiciona(UsuarioEntity t) {
		dao.adiciona(t);
	}

	@Override
	public void update(UsuarioEntity t) {
		dao.update(t);
	}

	@Override
	public void remove(UsuarioEntity t) {
		dao.remove(t);
	}

	@Override
	public UsuarioEntity recuperaById(Long id) {
		return dao.buscaPorId(id);
	}

	@Override
	public List<UsuarioEntity> recuperaTodos() {
		return dao.getAll();
	}

	public UsuarioEntity logar(UsuarioEntity usuario) {
		return dao.logar(usuario);
	}
	
	

}
