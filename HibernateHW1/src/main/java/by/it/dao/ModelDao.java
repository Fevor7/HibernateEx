package by.it.dao;

public interface ModelDao<T> {
	
	T add(T model);
	
	void delete(Integer id);
	
	T get(Integer id);
	
	void update(T model);
	 
}
