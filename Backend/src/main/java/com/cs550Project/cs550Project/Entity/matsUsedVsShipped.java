package com.cs550Project.cs550Project.Entity;

public class matsUsedVsShipped {
   private String manuf;
   private String matItem;
   private int requiredQty;
   private int shippedQty;
	public String getManuf() {
		return manuf;
	}
	public void setManuf(String manuf) {
		this.manuf = manuf;
	}
	public String getMatItem() {
		return matItem;
	}
	public void setMatItem(String matItem) {
		this.matItem = matItem;
	}
	public int getRequiredQty() {
		return requiredQty;
	}
	public void setRequiredQty(int requiredQty) {
		this.requiredQty = requiredQty;
	}
	public int getShippedQty() {
		return shippedQty;
	}
	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}
   
}
