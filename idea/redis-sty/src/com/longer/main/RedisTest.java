package com.longer.main;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: redis-sty
 * @description:
 * 需要下载redis.zip并解压
 * 需要启动redis服务
 * 然后下载redis.jar添加到运行环境中
 * @author: PuTao
 * @create: 2018-09-25 10:07
 **/
public class RedisTest {
	public static void main(String[] args){
//		pingTest();

		getAndSet();
		listTest();
	}
	static void pingTest(){
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println("正在连接");
		System.out.println("正在ping  "+jedis.ping());
	}

	static void getAndSet(){
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		jedis.set("key", "longer.com");
		System.out.println("key is "+ jedis.get("key"));
	}

	/**
	 * redis 采用的list的存储方式是先进后出
	 */
	static void listTest(){
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		jedis.lpush("l", "google");
		jedis.lpush("l", "longer");
		jedis.lpush("l", "baidu");
		List<String> list = jedis.lrange("l", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("veui "+i+"  "+list.get(i));
		}
	}
}
