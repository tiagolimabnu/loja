package br.com.loja.interfaces;

import java.util.List;

public interface IAssinaturaDAO<T> {

	public void adiciona(T t);

	public void update(T t);

	public void remove(T t);

	public T recuperaById(Long id);

	public List<T> recuperaTodos();

}
