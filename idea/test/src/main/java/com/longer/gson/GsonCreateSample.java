package com.longer.gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.longer.json.Longer;

import java.lang.reflect.Field;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-09-28 14:19
 **/
public class GsonCreateSample {
	public static void main(String[] args){
//		createGsonByBean();
		createGsonByGsonBuilder();
	}
	public static void createGsonByBean(){
		Longer longer = new Longer();
		longer.setName("lonver");
		longer.setAge(8999.3);
		longer.setBeauty("Goddes");
		longer.setGirls(false);
		longer.setComment("may you a super ");
		longer.setBirthday("3333-09-21");
		longer.setMajor(new String[]{"manage the universe","create new being"});
		Gson gson = new Gson();
		System.out.println(gson.toJson(longer));
	}

	/**
	 * setPrettyPrinting自动转为json的数据样式
	 */
	public static void createGsonByGsonBuilder(){
		Longer longer = new Longer();
		longer.setName("lonver");
		longer.setAge(8999.3);
		longer.setBeauty("Goddes");
		longer.setGirls(false);
		longer.setComment("may you a super ");
		longer.setBirthday("3333-09-21");
		longer.setMajor(new String[]{"manage the universe","create new being"});
		longer.setIgnore("heloo");
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
//		此方法与@SerializedName()注解有冲突
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			public String translateName(Field field) {
				if (field.getName().equals("girls")){
					return "FEMALE";
				}
				return field.getName();
			}
		});
		Gson gson = gsonBuilder.create();
//		因为使用@SerializedName()注解，所以，name=null
		System.out.println(gson.toJson(longer));
	}
}
