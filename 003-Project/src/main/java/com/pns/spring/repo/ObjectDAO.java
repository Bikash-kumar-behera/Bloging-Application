package com.pns.spring.repo;

import java.util.List;

public abstract class ObjectDAO<T> {
	public abstract boolean save(T t);
	public abstract T search(int id);
	public abstract boolean delete(int id);
	public abstract List<T> all();
}