package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "supplyUnitPricing")
public class supplyUnitPricing {
	@Id
	@Column(name = "supplier")
	private String supplier;
	

	@Column(name = "item")
	private String item;
	
	@Column(name = "ppu")
	private int ppu;
}
