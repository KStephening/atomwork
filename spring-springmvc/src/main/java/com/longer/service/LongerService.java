package com.longer.service;

import com.longer.entity.Longer;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:01
 **/
public interface LongerService {
	Long savePerson();

	Longer get(Long id);
}
