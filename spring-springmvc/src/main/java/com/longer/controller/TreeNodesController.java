package com.longer.controller;

import com.longer.entity.TreeNodes;
import com.longer.service.TreeNodesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-20 13:38
 **/
@Api(value = "TreeNodes")
@Controller
public class TreeNodesController {
	@Autowired
	TreeNodesService treeNodesService;

	@ApiOperation(value = "getLonger" , responseContainer = "Map",httpMethod = "POST")
	@PostMapping("/treenodes")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, paramType = "form", dataType = "Integer")
	})
	public Map<Integer, List<TreeNodes>> getTreeNodesList(Integer id) {
		return treeNodesService.getTreeNodesList(id);
	}
}
