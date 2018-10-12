package com.longer.scope;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-10-09 08:04
 **/
public class Test {
	public static void main(String[] args){
		A a = new A();
		a.setHa("ahhahaha");
		B b = new B();
		getA(a,b);
		System.out.println(b.getHaa());
	}
	private static void getA(A a,B b){
		b.setHaa(a.getHa());
	}
}
class A{
	private String ha;

	public String getHa() {
		return ha;
	}

	public void setHa(String ha) {
		this.ha = ha;
	}
}
class B{
	private String haa;

	public String getHaa() {
		return haa;
	}

	public void setHaa(String haa) {
		this.haa = haa;
	}
}