package com.longer.framework;

import java.io.Serializable;
import java.util.List;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 16:12
 **/
public interface DomainRepository <T,PK extends Serializable>{
	T load(PK id);

	T get(PK id);

	List<T> findAll();

	void persist(T entity);

	PK save(T entity);

	void saveOrUpdate(T entity);

	void delete(PK id);

	void flush();
}