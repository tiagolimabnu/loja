package br.com.loja.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.loja.entity.ClienteEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.entity.UsuarioEntity;

public class Dao<T> {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");

	private Class<T> classe;

	public Dao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	public void adiciona(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		manager.close();
	}

	public void update(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
		manager.close();
	}

	public void remove(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.merge(t));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public UsuarioEntity logar(UsuarioEntity usuario) {
		EntityManager manager = emf.createEntityManager();
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = (UsuarioEntity) manager.createQuery("from UsuarioEntity p where p.nome =:login and p.senha =:senha")
					.setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha()).getSingleResult() ;
		} catch (Exception e) {
			return null;
		}
		return usuarioEntity;
	}
	

	public T buscaPorId(Long id) {
		EntityManager manager = emf.createEntityManager();
		return manager.find(classe, id);
	}

	public ProdutoEntity buscaPorCodigoBarra(String codigo) {
		EntityManager manager = emf.createEntityManager();
		ProdutoEntity produto = null;
		try {
			produto = (ProdutoEntity) manager.createQuery("from ProdutoEntity p where p.codigoBarra =:barra")
					.setParameter("barra", codigo).getSingleResult();
		} catch (Exception e) {
			produto = null;
		}
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		EntityManager manager = emf.createEntityManager();
		return manager.createQuery("from " + classe.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteEntity> recuperaTodosClientes(){
		EntityManager  manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select c from ClienteEntity as c order by c.nome ");
		return manager.createQuery(sql.toString()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperaItensOrdenado(String parametroOrdenado) {
		EntityManager manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select p from ")
		.append(classe.getName())
		.append(" as p order by p.").append(parametroOrdenado);
		return manager.createQuery(sql.toString()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperaPorDescricao(String value) {
		EntityManager manager = emf.createEntityManager();
		return manager.createQuery("from ProdutoEntity p where p.descricao like :desc ")
				.setParameter("desc", "%" + value + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> recuperaItem(String valorARecuperar, String parametro) {
		EntityManager manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(classe.getName()).append(" p where upper (p.").append(parametro)
				.append(") like :param");
		return manager.createQuery(sql.toString()).setParameter("param", "%" + valorARecuperar.toUpperCase() + "%")
				.getResultList();
	}
	
	public void entradaProduto(ProdutoEntity produto) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery(
				"update ProdutoEntity p set p.quantidade = p.quantidade + :novaquantidade where p.id = :idproduto");
		query.setParameter("novaquantidade", produto.getQuantidade());
		query.setParameter("idproduto", produto.getId());
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void entradaProdutoGenerica(Long novaquantidade, Long produtoid) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery(
				"update "+classe+" p set p.quantidade = p.quantidade + :novaquantidade where p.id = :idproduto");
		query.setParameter("novaquantidade", novaquantidade);
		query.setParameter("idproduto", produtoid);
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void saidaProduto(ProdutoEntity produto) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery(
				"update ProdutoEntity p set p.quantidade = p.quantidade - :novaquantidade where p.id = :idproduto");
		query.setParameter("novaquantidade", produto.getQuantidade());
		query.setParameter("idproduto", produto.getId());
		query.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ProdutoEntity> recuperaPorData(Date inicio, Date fim) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("select p from ProdutoEntity p where p.data between :dinicio and :dfim");
		query.setParameter("dinicio", inicio);
		query.setParameter("dfim", fim);
		return query.getResultList();
	}

}
