package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manufUnitPricing")
public class manufUnitPricing {
	@Id
	@Column(name = "manuf")
	private String manuf;
	
	
	@Column(name = "prodItem")
	private String prodItem;
	
	@Column(name = "setUpCost")
	private int setUpCost;
	
	@Column(name = "prodCostPerUnit")
	private int prodCostPerUnit;
}
