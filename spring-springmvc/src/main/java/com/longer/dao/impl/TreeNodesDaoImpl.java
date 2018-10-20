package com.longer.dao.impl;

import com.longer.dao.TreeNodesDao;
import com.longer.entity.TreeNodes;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-20 13:24
 **/
@Repository
public class TreeNodesDaoImpl implements TreeNodesDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}

	public Map<Integer, List<TreeNodes>> getTreeNodesList(Integer id) {
		String hql = "select * from TreeNodes where FIND_IN_SET(id, getchildlist("+id+"))";
//		Query query = getCurrentSession().createQuery(hql);
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(hql).addEntity(TreeNodes.class);
		List<TreeNodes> treeNodes=(List<TreeNodes>)sqlQuery.list();
		Map<Integer, List<TreeNodes>> treeNodesMap=parseTreeNodes(treeNodes);
		System.out.println(treeNodesMap);
//		return (List<TreeNodes>)sqlQuery.list();
		return treeNodesMap;
	}

	public TreeNodes getChildTreeNode(List<TreeNodes> treeNodesList){
		TreeNodes treeNodes = null;
		List<TreeNodes> treeNodes1 = null;
		for (int i = 0; i < treeNodesList.size() ; i++) {
			treeNodes1 = new ArrayList<TreeNodes>();
			treeNodes = treeNodesList.get(i);
			for (int j = i+1; j < treeNodesList.size(); j++) {
				if (treeNodesList.get(j).getParentTreeNodes()==treeNodes){
					treeNodes1.add(treeNodesList.get(j));
				}
			}
			treeNodes.setChildTreeNodes(treeNodes1);
		}
		return treeNodesList.get(0);
	}

	public Map<Integer, List<TreeNodes>> parseTreeNodes(List<TreeNodes> treeNodesList){
		Map<Integer, List<TreeNodes>> treeNodesMap = new HashMap<Integer,  List<TreeNodes>>();
		List<TreeNodes> treeNodeses = null;
		TreeNodes treeNodes = null;
//		treeNodeses.add(treeNodesList.get(0));
//		treeNodesMap.put(0, treeNodeses);
		for (int i = 0; i < treeNodesList.size() ; i++) {
			treeNodeses = new ArrayList<TreeNodes>();
			treeNodes = treeNodesList.get(i);
			treeNodeses.add(treeNodes);
			for (int j = i+1; j < treeNodesList.size(); j++) {
				if (treeNodesList.get(j).getParentTreeNodes()==treeNodesList.get(i)) {
					treeNodeses.add(treeNodesList.get(j));
				}
			}
			if (treeNodeses!=null){
				treeNodesMap.put(treeNodes.getId(), treeNodeses);
			}
//			treeNodesMap.put(treeNodes.getParentTreeNodes().getId(), treeNodes);
		}
		return treeNodesMap;
	}




}
