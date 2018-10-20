package com.longer.dao;

import com.longer.entity.TreeNodes;

import java.util.List;
import java.util.Map;

public interface TreeNodesDao {
	Map<Integer, List<TreeNodes>> getTreeNodesList(Integer id);
}
