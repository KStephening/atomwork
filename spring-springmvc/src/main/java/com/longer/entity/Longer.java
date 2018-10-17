package com.longer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: spring-springmvc
 * @description: 使用@Data  自动生成get，set，toString等方法
 * @author: PuTao
 * @create: 2018-10-17 08:45
 **/
@Data
@Entity
@Table(name = "LONGER")
public class Longer {
	@Id
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private Long age;

}
