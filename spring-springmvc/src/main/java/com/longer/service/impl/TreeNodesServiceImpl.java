package com.longer.service.impl;

import com.longer.dao.TreeNodesDao;
import com.longer.entity.TreeNodes;
import com.longer.service.TreeNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-20 13:35
 **/
@Service
public class TreeNodesServiceImpl implements TreeNodesService{

	@Autowired
	TreeNodesDao treeNodesDao;
	public Map<Integer, List<TreeNodes>> getTreeNodesList(Integer id) {
		return (Map<Integer, List<TreeNodes>>)treeNodesDao.getTreeNodesList(id);
	}
}
