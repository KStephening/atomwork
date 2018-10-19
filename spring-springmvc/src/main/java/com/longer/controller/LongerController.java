package com.longer.controller;

import com.longer.entity.Longer;
import com.longer.service.LongerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:00
 **/
@Controller
@Api(value = "Longer", tags = {"Longer"})
public class LongerController {

	@Autowired
	private LongerService longerService;

	@RequestMapping(value = "saveLonger",method = RequestMethod.GET)
	@ApiOperation(value = "保存Longer")
	@ResponseBody
	public String saveLonger(){
		longerService.savePerson();
		return "success!!!";
	}

	@ApiOperation(value = "heeeeeee")
	@RequestMapping(value = "getLonger",method = RequestMethod.GET)
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, paramType = "query", dataType = "Long")
	})
	public Longer getLonger(Long id){
//		longerService.savePerson();
		Longer longer=longerService.get(id);
//		System.out.println(longer);
//		return "success!!!";
		return longer;
	}

}
