package com.longer.main;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @program: redis-sty
 * @description:
 * ��Ҫ����redis.zip����ѹ
 * ��Ҫ����redis����
 * Ȼ������redis.jar��ӵ����л�����
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
		System.out.println("��������");
		System.out.println("����ping  "+jedis.ping());
	}

	static void getAndSet(){
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		jedis.set("key", "longer.com");
		System.out.println("key is "+ jedis.get("key"));
	}

	/**
	 * redis ���õ�list�Ĵ洢��ʽ���Ƚ����
	 */
	static void listTest(){
		Jedis jedis = new Jedis("localhost");
		System.out.println("���ӳɹ�");
		jedis.lpush("l", "google");
		jedis.lpush("l", "longer");
		jedis.lpush("l", "baidu");
		List<String> list = jedis.lrange("l", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("veui "+i+"  "+list.get(i));
		}
	}
}
