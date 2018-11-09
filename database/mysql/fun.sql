CREATE FUNCTION CompanyTree(rootId INT(20))
  RETURNS VARCHAR(255)
  begin
	declare sTemp VARCHAR(255);
        DECLARE sTempChd VARCHAR(255);
		#初始化局部变量
       SET sTemp = '$';
		#调用cast函数将int转换为char
        SET sTempChd =cast(rootId as CHAR);
        #递归拼接
        WHILE sTempChd is not null DO
				#存储每次递归结果
        SET sTemp = concat(sTemp,',',sTempChd);
				#将参数作为pid，然后查询其子id，然后将子id作为pid，
        #查询以子id为pid的子id，依次循环下去，直到所有节点都为叶子节点
        SELECT group_concat(id) INTO sTempChd FROM  bd_truck_company  where FIND_IN_SET(PARENT_COMPANY_ID,sTempChd)>0;
    END WHILE;
    RETURN sTemp;
    end;
