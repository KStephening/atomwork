package com.longer.regex;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-09-30 08:28
 **/
public class Test {
	public static void main(String[] args){
		String no = "0000122";
		String a=no.replaceAll("^(0+)", "");

		System.out.println(a);
	}
}
