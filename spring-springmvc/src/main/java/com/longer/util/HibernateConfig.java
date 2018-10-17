package com.longer.util;

import org.hibernate.cfg.AnnotationConfiguration;
import com.longer.entity.Longer;
import org.hibernate.SessionFactory;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:06
 **/
public class HibernateConfig {
	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		try {
			factory = new AnnotationConfiguration().
					configure().
					//addPackage("com.xyz") //add package if used.
							addAnnotatedClass(Longer.class).
							buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}
}
