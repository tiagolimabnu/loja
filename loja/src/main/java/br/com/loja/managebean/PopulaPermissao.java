package br.com.loja.managebean;

import br.com.loja.entity.PermissoesEntity;
import br.com.loja.types.TipoPermissao;

public class PopulaPermissao {

	public PermissoesEntity permissao() {
		PermissoesEntity p = new PermissoesEntity();
		p.setTipoPermissao(TipoPermissao.A);
		return p;
	}
	
}
