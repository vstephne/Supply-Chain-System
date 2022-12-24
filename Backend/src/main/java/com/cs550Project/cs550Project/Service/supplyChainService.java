package com.cs550Project.cs550Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs550Project.cs550Project.Dao.*;
import com.cs550Project.cs550Project.Entity.items;
import com.cs550Project.cs550Project.Entity.shippedVSCustDemand;
import com.cs550Project.cs550Project.Entity.*;
@Service
public class supplyChainService {

	@Autowired
	private supplyChainDao supplyChainDao;

	public void insertItem(items itemObj) {
		this.supplyChainDao.insertItem(itemObj);
	}

	public List<shippedVSCustDemand> getShippedVSCustDemand() {
		return this.supplyChainDao.shippedVSCustDemand();
	}
	
	public List<totalManufItems> totalManufItems() {
		return this.supplyChainDao.totalManufItems();
	}
	
	public List<matsUsedVsShipped> matsUsedVsShipped() {
		return this.supplyChainDao.matsUsedVsShipped();
	}
	
	public List<producedVsShipped> producedVsShipped() {
		return this.supplyChainDao.producedVsShipped();
	}
	
	public List<suppliedVsShipped> suppliedVsShipped() {
		return this.supplyChainDao.suppliedVsShipped();
	}
	
	public List<perSupplierCost> perSupplierCost() {
		return this.supplyChainDao.perSupplierCost();
	}
	public List<perManufCost> perManufCost() {
		return this.supplyChainDao.perManufCost();
	}
}
