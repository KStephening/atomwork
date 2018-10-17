package com.longer.dao.impl;

import com.longer.dao.LongerDao;
import com.longer.entity.Longer;
import com.longer.util.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	public Longer getLongerById() {
		SessionFactory sessionFactory = HibernateConfig.getFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
			Longer longer=new Longer(1,"longer",20);
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
