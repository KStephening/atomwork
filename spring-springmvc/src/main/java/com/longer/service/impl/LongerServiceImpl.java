package com.longer.service.impl;

import com.longer.dao.LongerDao;
import com.longer.entity.Longer;
import com.longer.service.LongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-17 09:01
 **/
@Service("longerService")
public class LongerServiceImpl implements LongerService{

	@Autowired(required = true)
	private LongerDao longerDao;

	public Longer get(Long id) {
		return longerDao.get(id);
	}

	public Long savePerson() {
		Longer longer = new Longer();
		longer.setName("longer");
		longer.setAge(21L);
		return longerDao.save(longer);
	}
}
