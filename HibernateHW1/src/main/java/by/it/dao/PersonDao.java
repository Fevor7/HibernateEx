package by.it.dao;

import java.util.List;

public interface PersonDao<T> extends ModelDao<T> {
	
	List<T> getAll();

}
