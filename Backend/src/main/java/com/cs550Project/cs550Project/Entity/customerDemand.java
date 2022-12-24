package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerDemand")
public class customerDemand {
	@Id
	@Column(name = "customer")
	private String customer;
	

	@Column(name = "item")
	private String item;
	
	@Column(name = "qty")
	private int qty;
}
