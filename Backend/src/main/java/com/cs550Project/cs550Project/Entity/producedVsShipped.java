package com.cs550Project.cs550Project.Entity;

public class producedVsShipped {
	private String manuf;
	   private String matItem;
	   private int orderedQty;
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
	public int getOrderedQty() {
		return orderedQty;
	}
	public void setOrderedQty(int orderedQty) {
		this.orderedQty = orderedQty;
	}
	public int getShippedQty() {
		return shippedQty;
	}
	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}
}
