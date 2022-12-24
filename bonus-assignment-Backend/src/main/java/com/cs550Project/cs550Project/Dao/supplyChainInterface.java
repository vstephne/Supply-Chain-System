package com.cs550Project.cs550Project.Dao;

import java.util.List;

import com.cs550Project.cs550Project.Entity.items;
import com.cs550Project.cs550Project.Entity.matsUsedVsShipped;
import com.cs550Project.cs550Project.Entity.perManufCost;
import com.cs550Project.cs550Project.Entity.perSupplierCost;
import com.cs550Project.cs550Project.Entity.producedVsShipped;
import com.cs550Project.cs550Project.Entity.shippedVSCustDemand;
import com.cs550Project.cs550Project.Entity.suppliedVsShipped;
import com.cs550Project.cs550Project.Entity.totalManufItems;

public interface supplyChainInterface {
	void insertItem(items item);

	List<shippedVSCustDemand> shippedVSCustDemand();

	List<totalManufItems> totalManufItems();

	List<matsUsedVsShipped> matsUsedVsShipped();

	List<producedVsShipped> producedVsShipped();

	List<suppliedVsShipped> suppliedVsShipped();

	List<perSupplierCost> perSupplierCost();

	List<perManufCost> perManufCost();
}
