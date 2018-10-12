package com.longer.hibernate.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-10-12 11:47
 **/
@Entity
@Table(name = "menu")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "link")
	private String link;

	@Column(name = "grade")
	private Integer grade; //菜单等级

	@Column(name = "morder")
	private Integer morder; //同一级菜单中的顺序

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pid")
	private Menu parentMenu;
	//子菜单列表

	@OneToMany(targetEntity = Menu.class, cascade = { CascadeType.ALL }, mappedBy = "parentMenu")
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("morder")
	private List<Menu> childMenu = new ArrayList<Menu>();

	public Menu() {
		super();
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}


	public Menu getParentMenu() {
		return parentMenu;
	}


	public List<Menu> getChildMenu() {
		return childMenu;
	}

}
