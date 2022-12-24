package com.cs550Project.cs550Project.Entity;

public class suppliedVsShipped {
	private String item;
	private String supplier;
	   private int suppliedQty;
	   private int shippedQty;
	   
	   public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getSuppliedQty() {
		return suppliedQty;
	}
	public void setSuppliedQty(int suppliedQty) {
		this.suppliedQty = suppliedQty;
	}
	public int getShippedQty() {
		return shippedQty;
	}
	public void setShippedQty(int shippedQty) {
		this.shippedQty = shippedQty;
	}
	
	   
}
