package com.longer.single;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-09-29 11:35
 **/
public class HaTest1 {
	public static void main(String[] args){
		Ha ha = new Ha();
		ha.haa();
		Ho ho = new Ho();
		ho.hoo();
		LongerSingle longerSingle = LongerSingle.getInstance();
		System.out.println(longerSingle.toString());
	}
}
