package com.longer.json;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/**
 * @program: test
 * @description: 解析json
 * @author: PuTao
 * @create: 2018-09-28 13:54
 **/
public class ParseJSON {
	public static void main(String[] args) throws IOException,JSONException {
		parse();
	}

	/**
	 * idea和eclipse 的getResource方法是不一样的，idea必须从标记为resources的文件夹下获取文件
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void parse() throws IOException,JSONException {
		File file = new File(ParseJSON.class.getResource("/longer.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println("name: "+jsonObject.getString("name"));
		//为了防止name在文件中为空，可以使用下面的方式
		if (!jsonObject.isNull("name")){
			System.out.println("name: "+jsonObject.getString("name"));
		}
		System.out.println("age: "+jsonObject.getDouble("age"));
		System.out.println("girls: "+jsonObject.getBoolean("girls"));
		JSONArray jsonArray=jsonObject.getJSONArray("major");
		for (int i = 0; i < jsonArray.length(); i++) {
			String major=(String)jsonArray.get(i);
			System.out.println("major: "+major);
		}
		System.out.println();
	}

}
