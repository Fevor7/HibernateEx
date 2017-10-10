package by.it.dao;

import java.util.List;

public interface PersonDao<T> {

	T add(T model);

	void delete(Integer id);

	T get(Integer id);

	void update(T model);
	
	List<T> getAll();
}
