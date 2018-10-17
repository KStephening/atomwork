package com.longer.dao;

import com.longer.entity.Longer;
import com.longer.framework.DomainRepository;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:01
 **/

public interface LongerDao extends DomainRepository<Longer,Long>{
	Longer getLongerById();
}
