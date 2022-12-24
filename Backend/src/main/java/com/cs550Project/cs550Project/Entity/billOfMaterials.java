package com.cs550Project.cs550Project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busEntities")
public class billOfMaterials {

	@Id
	@Column(name = "prodItem")
	private String prodItem;

	@Column(name = "matItem")
	private String matItem;
	
	@Column(name = "QtyMatPerItem")
	private int QtyMatPerItem;
	
}
