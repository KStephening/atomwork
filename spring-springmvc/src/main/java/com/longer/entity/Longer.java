package com.longer.entity;

import lombok.Data;

import javax.persistence.*;

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
	@GeneratedValue
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AGE")
	private Long age;

}
