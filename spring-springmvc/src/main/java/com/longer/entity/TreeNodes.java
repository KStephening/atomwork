package com.longer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @program: spring-springmvc
 * @description:
 * @author: PuTao
 * @create: 2018-10-20 13:15
 **/
@Data
@Entity
@Table(name = "TREENODES")
public class TreeNodes {
	@Id
	private Integer id;

	@Column(name = "NODENAME")
	private String nodename;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PID")
	private TreeNodes parentTreeNodes;

	private List<TreeNodes> childTreeNodes;

	public List<TreeNodes> getChildTreeNodes() {
		return childTreeNodes;
	}

	public void setChildTreeNodes(List<TreeNodes> childTreeNodes) {
		this.childTreeNodes = childTreeNodes;
	}
}
