package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplyUnitPricing")
public class manufDiscounts {
	@Id
	@Column(name = "manuf")
	private String manuf;
	
	@Column(name = "amt1")
	private int amt1;
	
	@Column(name = "disc1")
	private int disc1;
}
