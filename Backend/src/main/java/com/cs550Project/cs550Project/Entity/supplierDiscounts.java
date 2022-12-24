package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplierDiscounts")
public class supplierDiscounts {
	@Id
	@Column(name = "supplier")
	private String supplier;
	
	@Column(name = "amt1")
	private int amt1;
	
	@Column(name = "disc1")
	private float disc1;
	
	@Column(name = "amt2")
	private int amt2;
	
	@Column(name = "disc2")
	private float disc2;
}
