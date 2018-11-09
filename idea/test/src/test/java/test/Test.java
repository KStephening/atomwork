package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-10-20 11:08
 **/
public class Test {
	@org.junit.Test
	public void testA() {
		String a = "mysql> CREATE FUNCTION `getChildLst`(rootId INT)\n" +
				"    -> RETURNS varchar(1000)\n" +
				"    -> BEGIN\n" +
				"    ->   DECLARE sTemp VARCHAR(1000);\n" +
				"    ->   DECLARE sTempChd VARCHAR(1000);\n" +
				"    ->\n" +
				"    ->   SET sTemp = '$';\n" +
				"    ->   SET sTempChd =cast(rootId as CHAR);\n" +
				"    ->\n" +
				"    ->   WHILE sTempChd is not null DO\n" +
				"    ->     SET sTemp = concat(sTemp,',',sTempChd);\n" +
				"    ->     SELECT group_concat(id) INTO sTempChd FROM treeNodes where FIND_IN_SET(pid,sTempChd)>0;\n" +
				"    ->   END WHILE;\n" +
				"    ->   RETURN sTemp;\n" +
				"    -> END\n" +
				"    -> //\n" +
				"--------------------- \n" +
				"作者：ACMAIN_CHM \n" +
				"来源：CSDN \n" +
				"原文：https://blog.csdn.net/acmain_chm/article/details/4142971 \n" +
				"版权声明：本文为博主原创文章，转载请附上博文链接！";
		String b = a.toLowerCase();
		System.out.println(b);

	}

	@org.junit.Test
	public void testB(){
		String a = "ajjj";
		String[] b = a.split(",");

		System.out.println(b.length);
		System.out.println(b[0]);
	}

	@org.junit.Test
	public void testDate(){
		String a = "1533089565000";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(Long.valueOf(a));
		System.out.println(date);
	}
}
