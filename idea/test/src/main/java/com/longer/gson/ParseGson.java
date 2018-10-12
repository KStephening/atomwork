package com.longer.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.longer.json.Longer;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @program: test
 * @description: 解析GSON
 * 关于Gson https://blog.csdn.net/wl1769127285/article/details/51076683
 * @author: PuTao
 * @create: 2018-09-28 14:34
 */
public class ParseGson {
	public static void main(String[] args) throws IOException {
//		parse();
//		parseByGsonBuilder();
		parseTwo();
		ParseGson parseGson = new ParseGson();
	}

	public static void parse() throws IOException {
		File file = new File(ParseGson.class.getResource("/longer.json").getFile());
		String content = FileUtils.readFileToString(file);
		Gson gson = new Gson();
		Longer longer = gson.fromJson(content, Longer.class);
		System.out.println(longer.toString());
	}

	/**
	 * 解决日期问题
	 * @throws IOException
	 */
	public static void parseByGsonBuilder() throws IOException {
		File file = new File(ParseGson.class.getResource("/longer2.json").getFile());
		String content = FileUtils.readFileToString(file);
		GsonBuilder gsonBuilder = new GsonBuilder();
		//日期格式转换
		Gson gson =gsonBuilder.setDateFormat("yyyy-MM-dd").create();
		Longer longer = gson.fromJson(content, Longer.class);
		System.out.println(longer.getDay().toLocaleString());
	}

	/**
	 * Gson会自动转换集合，设置默认的集合类型
	 * @throws IOException
	 */
	public static void parseTwo() throws IOException {
		File file = new File(ParseGson.class.getResource("/longer3.json").getFile());
		String content = FileUtils.readFileToString(file);
		GsonBuilder gsonBuilder = new GsonBuilder();
		//日期格式转换    序列换空值（否则会默认忽略空值）
		Gson gson =gsonBuilder.setDateFormat("yyyy-MM-dd").serializeNulls().create();
		Longer longer = gson.fromJson(content, Longer.class);
		System.out.println(longer.getDay().toLocaleString());
		System.out.println(longer.getHobby());
		//ArrayList
		System.out.println(longer.getHobby().getClass());
	}

}
