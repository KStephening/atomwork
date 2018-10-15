package com.longer.hibernate.entity;


import javax.persistence.*;


/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-10-12 11:47
 **/

@NamedQueries(
		{
				@NamedQuery(
						name = "findMenuByName",
						query = "from Menu m where m.name=:name"
				)
		}
)
@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "link")
	private String link;

	@Column(name = "grade")
	private Integer grade; //菜单等级

	@Column(name = "morder")
	private Integer morder; //同一级菜单中的顺序

//	@Column(name = "pid")
//	private Integer pid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pid")
	private Menu parentMenu;

	public Menu(Integer id, String name, String link, Integer grade, Integer morder) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.grade = grade;
		this.morder = morder;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	//子菜单列表

//	@OneToMany(targetEntity = Menu.class, cascade = { CascadeType.ALL }, mappedBy = "parentMenu")
//	@Fetch(FetchMode.SUBSELECT)
//	@OrderBy("morder")
//	private List<Menu> childMenu = new ArrayList<Menu>();

	public Menu() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getMorder() {
		return morder;
	}

	public void setMorder(Integer morder) {
		this.morder = morder;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Menu{" +
				"id=" + id +
				", name='" + name + '\'' +
				", link='" + link + '\'' +
				", grade=" + grade +
				", morder=" + morder +
				'}';
	}
}
