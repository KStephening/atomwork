package com.longer.json;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: http://jsoneditoronline.org/ 在线转换json格式
 * @author: PuTao
 * @create: 2018-09-28 11:44
 **/
public class JsonObjectSample {
	public static void main(String[] args){
		createJsonByJSONObject();
//		createJsonByHashMap();
//		createJsonByJavaBean();
	}


	/**
	 * 通过javabean创建一个json  推荐使用这种方式
	 */
	public static void createJsonByJavaBean(){
		Longer longer = new Longer();
		longer.setName("lonver");
		longer.setAge(8999.3);
		longer.setBeauty("Goddes");
		longer.setGirls(false);
		longer.setComment("may you a super ");
		longer.setBirthday("3333-09-21");
		longer.setMajor(new String[]{"manage the universe","create new being"});
		System.out.println(new JSONObject(longer));


	}

	/**
	 * 使用JSONObject这种原生的方式创建json
	 */
	public static void createJsonByJSONObject(){
		JSONObject longer = new JSONObject();
		Object objNull=null;
		try {
			longer.put("name", "Menu");
			longer.put("birthday","1990-01-01");
			longer.put("major", new String[]{"coder", "actor"});
			longer.put("girls", false);
			//如果直接传入null，有二义性，所以自定义一个null
			longer.put("beauty", objNull);
			longer.put("comment", "json固定的注释，只有新建一个属性为注释");
			//利用toString直接输出json格式的数据
			System.out.println(longer.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 *HashMap创建json
	 */
	public static void createJsonByHashMap(){
		Map<String, Object> longer = new HashMap<String, Object>();
		Object objNull=null;
		longer.put("name", "Menu");
		longer.put("birthday","1990-01-01");
		longer.put("major", new String[]{"coder", "actor"});
		longer.put("girls", false);
		longer.put("beauty", objNull);
		longer.put("comment", "json固定的注释，只有新建一个属性为注释");
		//利用JSONObject的构造器
		System.out.println(new JSONObject(longer).toString());
	}

}
