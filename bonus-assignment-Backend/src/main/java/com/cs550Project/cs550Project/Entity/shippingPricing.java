package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shippingPricing")
public class shippingPricing {

	@Id
	@Column(name = "shipper")
	private String shipper;
	
	
	@Column(name = "fromLoc")
	private int fromLoc;
	

	@Column(name = "toLoc")
	private int toLoc;
	
	@Column(name = "minPackagePrice")
	private int minPackagePrice;
	
	@Column(name = "pricePerLb")
	private int pricePerLb;
	
	@Column(name = "amt1")
	private int amt1;
	
	@Column(name = "disc1")
	private float disc1;
	
	@Column(name = "amt2")
	private int amt2;
	
	@Column(name = "disc2")
	private float disc2;
}
