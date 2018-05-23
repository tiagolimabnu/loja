package br.com.loja.entity;

import java.util.List;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.ProdutoDAO;

public class Teste {

	//create database loja charset latin1 collate latin1_general_cs;
	
	public static void main(String[] args) {
		
		List<ProdutoEntity> ordenado = new ProdutoDAO().recuperaItensOrdenado();
		
		for (ProdutoEntity um : ordenado) {
			System.out.println(um.getDescricao());
		}
		
		
//		UsuarioEntity usuario1 = new UsuarioEntity();
//		usuario1.setTipoUsuario(TipoUsuario.CARROC);
//		
//		
//		ProdutoDTO produto = new ProdutoDTO();
//		
//		produto.setCodigoBarra("123");
//		produto.setData(new Date());
//		produto.setDescricao("parafuzo");
//		produto.setPrecoVenda(100.0);
//		produto.setQuantidade(10L);
//		
//		ProdutoEntityA produtoa = new ProdutoEntityA();
//		
//		produtoa.setCodigoBarra(produto.getCodigoBarra());
//		produtoa.setData(produto.getData());
//		produtoa.setDescricao(produto.getCodigoBarra());
//		produtoa.setPrecoVenda(produto.getPrecoVenda());
//		produtoa.setQuantidade(produto.getQuantidade());
//		
//		ProdutoEntityC produtoc = new ProdutoEntityC();
//		produtoc.setCodigoBarra(produto.getCodigoBarra());
//		produtoc.setData(produto.getData());
//		produtoc.setDescricao(produto.getCodigoBarra());
//		produtoc.setPrecoVenda(produto.getPrecoVenda());
//		produtoc.setQuantidade(produto.getQuantidade());
//		
//		
//		if (usuario1.getTipoUsuario().equals(TipoUsuario.CARROA)) {
//			new ProdutoADAO().adiciona(produtoa);
//		}
//		
//		if (usuario1.getTipoUsuario().equals(TipoUsuario.CARROC)) {
//			new ProdutoCDAO().adiciona(produtoc);
//		}
//		
		
		
		
	}

}
