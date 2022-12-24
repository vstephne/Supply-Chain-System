package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busEntities")
public class busEntities {
	@Id
	@Column(name = "entity")
	private String entity;
	
	@Column(name = "shipLoc")
	private String shipLoc;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "contact")
	private String contact;
}
