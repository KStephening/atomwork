package com.longer.hibernate.session;

import com.longer.hibernate.entity.Menu;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class BasicTest {
	private static SessionFactory factory;

	public static void main(final String[] args) throws Exception {
		try {
			factory = new AnnotationConfiguration().
					configure().
					//addPackage("com.xyz") //add package if used.
							addAnnotatedClass(Menu.class).
							buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		BasicTest basicTest = new BasicTest();
		Menu menu=basicTest.getMenuByName("s");
		System.out.println(menu);
//		basicTest.listMenu();

//		basicTest.getParentMenu(4);
//		Menu parentMenu = basicTest.getMenuById(2);
//		Menu childMenu1 = new Menu(5, "s", "url5", 3, 2);
//		Menu childMenu2 = new Menu(6, "s2", "url6", 3, 3);

//		Menu parentMenu = new Menu(7, "super", "url7", 2, 3);
//		childMenu1.setParentMenu(parentMenu);
//		childMenu2.setParentMenu(parentMenu);
//		basicTest.saveChildMenu(childMenu1);
//		basicTest.saveChildMenu(childMenu2);
//
//		basicTest.getMenuById(6);
//
//		basicTest.getMenuById(5);
	}

	/**
	 * 注意： createQuery("FROM Menu")  from后面跟的是Menu类名   不可以是数据库中的表名
	 */
	public void listMenu() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Menu> menu = session.createQuery("FROM Menu").list();
			for (Menu menu1 : menu) {
				System.out.println(menu1);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 获取所属的上级菜单
	 *
	 * @param pid
	 */
	public void getParentMenu(Integer pid) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "from Menu Where id =" + pid;
			Menu menu = (Menu) session.createQuery(hql).uniqueResult();
			System.out.println("==========================");
			System.out.println("==========================");
			System.out.println("==========================");
			System.out.println(menu.getParentMenu());
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * 保存子菜单    如果父菜单已经确定
	 * @param childMenu
	 */
	public void saveChildMenu(Menu childMenu) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(childMenu);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}


	}

	public Menu getMenuById(Integer id) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Menu menu = null;
		try {
			transaction = session.beginTransaction();
			String hql = "from Menu Where id =" + id;
			menu = (Menu) session.createQuery(hql).uniqueResult();
			System.out.println("menu id==" + menu.getId() + "----------" + menu);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return menu;
	}

	/**
	 * 通过Menu中的注解查询
	 * @param name
	 * @return
	 */
	public Menu getMenuByName(String name){
		Session session = factory.openSession();
		Transaction transaction = null;
		Menu menu = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("findMenuByName");
			query.setString("name",name);
			menu = (Menu) query.uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return menu;
	}
}

