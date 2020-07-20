package com.licitacion.service;

import java.util.List;

public interface GenericService <E> {

	public E get(long id);
	
	public List<E> get();
	
	public void insert (E entity);
	
	public void update(E entity);
	
	public void delete(long id);

}
