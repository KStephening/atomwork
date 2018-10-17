package com.longer.dao.impl;

import com.longer.dao.LongerDao;
import com.longer.entity.Longer;
import com.longer.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:01
 **/
@Repository(value = "longerDao")
public class LongerDaoImpl implements LongerDao{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}

	public Longer load(Long id) {
		return (Longer) getCurrentSession().load(Longer.class,id);
	}

	public Longer get(Long id) {
		return (Longer) getCurrentSession().get(Longer.class,id);
	}

	public List<Longer> findAll() {
		return null;
	}

	public void persist(Longer entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Longer entity) {
		Session session = getCurrentSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.save(entity);
			transaction.commit();
		}catch (Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		session.close();
		return 1L;
	}

	public void saveOrUpdate(Longer entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		Longer longer = load(id);
		getCurrentSession().delete(longer);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	public Longer getLongerById() {
		SessionFactory sessionFactory = HibernateConfig.getFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
//			Longer longer=new Longer(1,"longer",20);
			Longer longer = new Longer();
			session.save(longer);
			List<Longer> longers = session.createQuery("FROM Longer ").list();
			for (Longer longer1:longers){
				System.out.println(longer1);
			}
		}catch (Exception e){
			if (transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
}
