package com.edutecno.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	List<T> getAll();
	T getById(int id);
	void save(T t);
	void delete(int id);
}
