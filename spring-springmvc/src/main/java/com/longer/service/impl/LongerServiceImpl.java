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
@Transactional
public class LongerServiceImpl implements LongerService{

	@Autowired
	private LongerDao longerDao;

	public Longer get(Long id) {
		return longerDao.get(id);
	}

	public Long savePerson() {
		Longer longer = new Longer();
		longer.setName("longer");
		longer.setId(1L);
		longer.setAge(20L);
		longerDao.save(longer);
		longerDao.flush();
		return 1L;
	}
}
