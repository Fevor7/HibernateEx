package by.it.dao;

public interface SFPersonDao<T> extends ModelDao<T>{

	T load(Integer id); 
}
