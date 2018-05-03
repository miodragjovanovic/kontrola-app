package com.name.no.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "node")
public class NodeEntity {

	@Id
	@Column(length = 36)
	private String id;
	@Column(length = 30)
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	private NodeEntity parent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeEntity getParent() {
		return parent;
	}

	public void setParent(NodeEntity parent) {
		this.parent = parent;
	}

}
