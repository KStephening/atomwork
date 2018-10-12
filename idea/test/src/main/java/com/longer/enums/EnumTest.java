package com.longer.enums;

import java.util.Scanner;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-10-09 11:13
 **/
public class EnumTest {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个大小：（SMALL，MEDIUM）");
		String input = scanner.next().toUpperCase();
		//valueOf方法获取指定的enum的一个枚举
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size:"+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if (size==Size.MEDIUM){
			System.out.println("you choose is Medium");
		}
		//compareTo   如果小于返回负值    大于返回正值  等于返回 0
		System.out.println(size.compareTo(Enum.valueOf(Size.class,"SMALL")));
	}
}

/**
 * 创建枚举类   并设置构造属性和构造函数
 */
enum Size{
	SMALL("S"), MEDIUM("M");
	private String abbreviation;
	private Size(String abbreviation){
		this.abbreviation = abbreviation;
	}
	public String getAbbreviation(){
		return abbreviation;
	}

}

enum Size2{SMALL,MEDIUM,LARGE,EXTRA_LARGE}