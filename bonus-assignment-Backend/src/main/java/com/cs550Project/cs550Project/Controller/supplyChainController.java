package com.cs550Project.cs550Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs550Project.cs550Project.Entity.items;
import com.cs550Project.cs550Project.Entity.shippedVSCustDemand;
import com.cs550Project.cs550Project.Service.*;
import com.cs550Project.cs550Project.Entity.*;
@RestController

public class supplyChainController {
	@Autowired
	private supplyChainService supplyChainService;
	
	@PostMapping
	public void insertUser(@RequestBody items item) {
		supplyChainService.insertItem(item);
	}
	
	@GetMapping("/getShippedVSCustDemand")
	public List<shippedVSCustDemand>  getShippedVSCustDemand() {
		return supplyChainService.getShippedVSCustDemand();
	}
	
	@GetMapping("/getTotalManufItems")
	public List<totalManufItems>  totalManufItems() {
		return supplyChainService.totalManufItems();
	}
	
	@GetMapping("/getMatsUsedVsShipped")
	public List<matsUsedVsShipped>  matsUsedVsShipped() {
		return supplyChainService.matsUsedVsShipped();
	}
	
	@GetMapping("/getproducedVsShipped")
	public List<producedVsShipped>  producedVsShipped() {
		return supplyChainService.producedVsShipped();
	}
	
	@GetMapping("/getsuppliedVsShipped")
	public List<suppliedVsShipped>  suppliedVsShipped() {
		return supplyChainService.suppliedVsShipped();
	}
	
	@GetMapping("/getPerSupplierCost")
	public List<perSupplierCost>  perSupplierCost() {
		return supplyChainService.perSupplierCost();
	}
	
	@GetMapping("/getperManufCost")
	public List<perManufCost>  perManufCost() {
		return supplyChainService.perManufCost();
	}
}
