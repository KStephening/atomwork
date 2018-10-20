package com.longer.service;

import com.longer.entity.TreeNodes;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Map;

public interface TreeNodesService {
	Map<Integer, List<TreeNodes>> getTreeNodesList(Integer id);
}
