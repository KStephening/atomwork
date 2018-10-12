package com.longer.json;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: test
 * @description: this is a java bean
 * @author: PuTao
 * @create: 2018-09-28 11:58
 **/
public class Longer {
	//利用Gson转为json的时候，会选择使用NAME
	@SerializedName("NAME")
	private String name;
	private String[] major;
	/**
	 * Gson会识别集合
	 */
	private List<String> hobby;
	private String comment;
	private boolean girls;
	private String beauty;
	private double age;
	private String  birthday;
	private Date day;



	public Date getDay() {
		return day;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Menu{" +
				"name='" + name + '\'' +
				", major=" + Arrays.toString(major) +
				", comment='" + comment + '\'' +
				", girls=" + girls +
				", beauty='" + beauty + '\'' +
				", age=" + age +
				", birthday='" + birthday + '\'' +
				", day=" + day +
				", ignore='" + ignore + '\'' +
				'}';
	}

	public void setDay(Date day) {
		this.day = day;
	}

	/**
	 * 生成json的时候不会看到这个
	 */
	private transient String ignore;

	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMajor() {
		return major;
	}

	public void setMajor(String[] major) {
		this.major = major;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isGirls() {
		return girls;
	}

	public void setGirls(boolean girls) {
		this.girls = girls;
	}

	public String getBeauty() {
		return beauty;
	}

	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
