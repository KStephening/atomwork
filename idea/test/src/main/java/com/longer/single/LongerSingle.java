package com.longer.single;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-09-29 11:33
 **/
public class LongerSingle {
	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "LongerSingle{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	private static LongerSingle longerSingle;

	public static LongerSingle getInstance(){
		if (longerSingle==null){
			return new LongerSingle();
		}
		return longerSingle;
	}
	private LongerSingle(){}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
