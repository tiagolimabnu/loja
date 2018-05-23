package br.com.loja.as;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.loja.dao.ProdutoADAO;
import br.com.loja.dao.ProdutoBDAO;
import br.com.loja.dao.ProdutoCDAO;
import br.com.loja.dao.ProdutoDDAO;
import br.com.loja.dao.ProdutoEDAO;
import br.com.loja.dao.ProdutoFDAO;
import br.com.loja.entity.ProdutoDTO;
import br.com.loja.entity.ProdutoEntityA;
import br.com.loja.entity.ProdutoEntityB;
import br.com.loja.entity.ProdutoEntityC;
import br.com.loja.entity.ProdutoEntityD;
import br.com.loja.entity.ProdutoEntityE;
import br.com.loja.entity.ProdutoEntityF;
import br.com.loja.entity.UsuarioEntity;
import br.com.loja.types.TipoCarros;
import br.com.loja.types.TipoUsuario;

@ApplicationScoped
public class ProdutoExternoAS implements Serializable {

	private static final long serialVersionUID = 6129618031504662884L;
	
	@Inject
	private ProdutoADAO produtoADAO;

	@Inject
	private ProdutoBDAO produtoBDAO;

	@Inject
	private ProdutoCDAO produtoCDAO;

	@Inject
	private ProdutoDDAO produtoDDAO;

	@Inject
	private ProdutoEDAO produtoEDAO;

	@Inject
	private ProdutoFDAO produtoFDAO;
	
	
	public List<ProdutoDTO> recuperaProdutoExternos(){
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNome("andre");
		usuario.setSenha("123");
		usuario.setTipoUsuario(TipoUsuario.CARROB);

		TipoUsuario tipo = usuario.getTipoUsuario();
		
		ProdutoDTO produto = null;
		List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
		switch (tipo) {
		case CARROA:
				List<ProdutoEntityA> produtosA = produtoADAO.recuperaTodos();
				for (ProdutoEntityA umProduto : produtosA) {
					produto = new ProdutoDTO();
					produto.setCodigoBarra(umProduto.getCodigoBarra());
					produto.setDescricao(umProduto.getDescricao());
					produto.setQuantidade(umProduto.getQuantidade());
					produto.setPrecoVenda(umProduto.getPrecoVenda());
					produto.setData(umProduto.getData());
					produtos.add(produto);
				}
			break;
			
		case CARROB:
			List<ProdutoEntityB> produtosB = produtoBDAO.recuperaTodos();
			for (ProdutoEntityB umProduto : produtosB) {
				produto = new ProdutoDTO();
				produto.setCodigoBarra(umProduto.getCodigoBarra());
				produto.setDescricao(umProduto.getDescricao());
				produto.setQuantidade(umProduto.getQuantidade());
				produto.setPrecoVenda(umProduto.getPrecoVenda());
				produto.setData(umProduto.getData());
				produtos.add(produto);
			}
				
		break;

		default:
			break;
		}
		
		return produtos;
		
	}
	  
	
	public void cadatrarProdutoExterno(ProdutoDTO produto) {
		TipoCarros tipo = produto.getTipo();

		switch (tipo) {
		
				case CARROA:
					ProdutoEntityA produtoEntityA = new ProdutoEntityA();
					produtoEntityA.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityA.setData(produto.getData());
					produtoEntityA.setDescricao(produto.getDescricao());
					produtoEntityA.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityA.setQuantidade(produto.getQuantidade());
					produtoADAO.adiciona(produtoEntityA);
					break;
		
				case CARROB:
					ProdutoEntityB produtoEntityB = new ProdutoEntityB();
					produtoEntityB.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityB.setData(produto.getData());
					produtoEntityB.setDescricao(produto.getDescricao());
					produtoEntityB.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityB.setQuantidade(produto.getQuantidade());
					produtoBDAO.adiciona(produtoEntityB);
					break;
		
				case CARROC:
					ProdutoEntityC produtoEntityC = new ProdutoEntityC();
					produtoEntityC.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityC.setData(produto.getData());
					produtoEntityC.setDescricao(produto.getDescricao());
					produtoEntityC.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityC.setQuantidade(produto.getQuantidade());
					produtoCDAO.adiciona(produtoEntityC);
					break;
		
				case CARROD:
					ProdutoEntityD produtoEntityD = new ProdutoEntityD();
					produtoEntityD.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityD.setData(produto.getData());
					produtoEntityD.setDescricao(produto.getDescricao());
					produtoEntityD.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityD.setQuantidade(produto.getQuantidade());
					produtoDDAO.adiciona(produtoEntityD);
					break;
		
				case CARROE:
					ProdutoEntityE produtoEntityE = new ProdutoEntityE();
					produtoEntityE.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityE.setData(produto.getData());
					produtoEntityE.setDescricao(produto.getDescricao());
					produtoEntityE.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityE.setQuantidade(produto.getQuantidade());
					produtoEDAO.adiciona(produtoEntityE);
					break;
				case CARROF:
					ProdutoEntityF produtoEntityF = new ProdutoEntityF();
					produtoEntityF.setCodigoBarra(produto.getCodigoBarra());
					produtoEntityF.setData(produto.getData());
					produtoEntityF.setDescricao(produto.getDescricao());
					produtoEntityF.setPrecoVenda(produto.getPrecoVenda());
					produtoEntityF.setQuantidade(produto.getQuantidade());
					produtoFDAO.adiciona(produtoEntityF);
					break;
					
				default:
					break;
		}

	}


	public List<ProdutoDTO> recuperaProdutosExternoPorEstoque(ProdutoDTO produto) {

		TipoCarros tipo = produto.getTipo();
		
		ProdutoDTO novoProduto = null;
		List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
		
		switch (tipo) {
		case CARROA:
				List<ProdutoEntityA> produtosA = produtoADAO.recuperaTodos();
				for (ProdutoEntityA umProduto : produtosA) {
					novoProduto = new ProdutoDTO();
					novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
					novoProduto.setDescricao(umProduto.getDescricao());
					novoProduto.setQuantidade(umProduto.getQuantidade());
					novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
					novoProduto.setData(umProduto.getData());
					produtos.add(novoProduto);
				}
			break;
			
		case CARROB:
			List<ProdutoEntityB> produtosB = produtoBDAO.recuperaTodos();
			for (ProdutoEntityB umProduto : produtosB) {
				novoProduto = new ProdutoDTO();
				novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
				novoProduto.setDescricao(umProduto.getDescricao());
				novoProduto.setQuantidade(umProduto.getQuantidade());
				novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
				novoProduto.setData(umProduto.getData());
				produtos.add(novoProduto);
			}
			
		case CARROC:
			List<ProdutoEntityC> produtosC = produtoCDAO.recuperaTodos();
			for (ProdutoEntityC umProduto : produtosC) {
				novoProduto = new ProdutoDTO();
				novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
				novoProduto.setDescricao(umProduto.getDescricao());
				novoProduto.setQuantidade(umProduto.getQuantidade());
				novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
				novoProduto.setData(umProduto.getData());
				produtos.add(novoProduto);
			}	
		
		case CARROD:
			List<ProdutoEntityD> produtosD = produtoDDAO.recuperaTodos();
			for (ProdutoEntityD umProduto : produtosD) {
				novoProduto = new ProdutoDTO();
				novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
				novoProduto.setDescricao(umProduto.getDescricao());
				novoProduto.setQuantidade(umProduto.getQuantidade());
				novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
				novoProduto.setData(umProduto.getData());
				produtos.add(novoProduto);
			}
			
		case CARROE:
			List<ProdutoEntityE> produtosE = produtoEDAO.recuperaTodos();
			for (ProdutoEntityE umProduto : produtosE) {
				novoProduto = new ProdutoDTO();
				novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
				novoProduto.setDescricao(umProduto.getDescricao());
				novoProduto.setQuantidade(umProduto.getQuantidade());
				novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
				novoProduto.setData(umProduto.getData());
				produtos.add(novoProduto);
			}
			
		case CARROF:
			List<ProdutoEntityF> produtosF = produtoFDAO.recuperaTodos();
			for (ProdutoEntityF umProduto : produtosF) {
				novoProduto = new ProdutoDTO();
				novoProduto.setCodigoBarra(umProduto.getCodigoBarra());
				novoProduto.setDescricao(umProduto.getDescricao());
				novoProduto.setQuantidade(umProduto.getQuantidade());
				novoProduto.setPrecoVenda(umProduto.getPrecoVenda());
				novoProduto.setData(umProduto.getData());
				produtos.add(novoProduto);
			}	
			
		break;

		default:
			break;
		}
		
		return produtos;
	}

}
