package com.cs550Project.cs550Project.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs550Project.cs550Project.Entity.*;


@Repository
public class supplyChainDao implements supplyChainInterface{
	@Autowired
	private JdbcTemplate jdbcTemplate;



	@Override
	public void insertItem(items itemObj) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO  ITEMS(item,unitWeight) values(?,?)";

		final String item = itemObj.getItem();
		final int unitWeight = itemObj.getUnitWeight();

		jdbcTemplate.update(sql, new Object[] { item,unitWeight });

	}
	
	@Override
	public List<shippedVSCustDemand> shippedVSCustDemand() {
		// TODO Auto-generated method stub
		final String sql = "select cs.customer as customer, cs.item as item,so.qty as suppliedQty, cs.qty as demandQty\r\n"
				+ "		from customerDemand cs left outer join shipOrders so on cs.item = so.item and cs.customer = so.recipient\r\n"
				+ "		group by cs.customer,cs.item,cs.qty\r\n"
				+ "		order by cs.customer, cs.item\r\n"
				+ "		;";

		 List<shippedVSCustDemand> shippedVSCustDemandList= jdbcTemplate.query(sql,  new RowMapper<shippedVSCustDemand>() {
			  public shippedVSCustDemand mapRow(ResultSet resultSet, int i) throws SQLException {
				  shippedVSCustDemand  shippedVSCustDemand= new shippedVSCustDemand();
				  shippedVSCustDemand.setItem(resultSet.getString("item"));
				  shippedVSCustDemand.setCustomer(resultSet.getString("customer"));
				  return shippedVSCustDemand;
			  }
		  });

		return shippedVSCustDemandList;
	}
	
	@Override
	public List<totalManufItems> totalManufItems() {
		// TODO Auto-generated method stub
		final String sql = "select ma.item as item, sum(ma.qty) as totalManufQty\r\n"
				+ "		from manufOrders ma\r\n"
				+ "		group by ma.item\r\n"
				+ "		order by ma.item\r\n"
				+ "		;";

		 List<totalManufItems> totalManufItemsList= jdbcTemplate.query(sql,  new RowMapper<totalManufItems>() {
			  public totalManufItems mapRow(ResultSet resultSet, int i) throws SQLException {
				  totalManufItems  totalManufItem= new totalManufItems();
				  totalManufItem.setItem(resultSet.getString("item"));
				  totalManufItem.setTotalManufQty(resultSet.getInt("totalManufQty"));
				  return totalManufItem;
			  }
		  });

		return totalManufItemsList;
	}
	
	@Override
	public List<matsUsedVsShipped> matsUsedVsShipped() {
		// TODO Auto-generated method stub
		final String sql = "select Req.manuf, req.matItem, req.requiredQty, sum(so.qty) as shippedQty\r\n"
				+ "	from(select ma.manuf as manuf , bo.matItem as matItem, sum( ma.qty * bo.QtyMatPerItem) as requiredQty\r\n"
				+ "	from manufOrders ma,billOfMaterials bo\r\n"
				+ "	where ma.item = bo.prodItem\r\n"
				+ "	group by ma.manuf, bo.matItem) Req left outer join shipOrders so on Req.manuf = so.recipient and Req.matItem = so.item\r\n"
				+ "	group by Req.manuf, req.matItem,req.requiredQty\r\n"
				+ "	order by Req.manuf, req.matItem\r\n"
				+ "	;";

		 List<matsUsedVsShipped> matsUsedVsShippedList= jdbcTemplate.query(sql,  new RowMapper<matsUsedVsShipped>() {
			  public matsUsedVsShipped mapRow(ResultSet resultSet, int i) throws SQLException {
				  matsUsedVsShipped  matsUsedVsShipped= new matsUsedVsShipped();
				  matsUsedVsShipped.setManuf(resultSet.getString("manuf"));
				  matsUsedVsShipped.setRequiredQty(resultSet.getInt("requiredQty"));
				  matsUsedVsShipped.setShippedQty(resultSet.getInt("shippedQty"));
				  return matsUsedVsShipped;
			  }
		  });

		return matsUsedVsShippedList;
	}
	
	@Override
	public List<producedVsShipped> producedVsShipped() {
		// TODO Auto-generated method stub
		final String sql = "select	ma.item as item, ma.manuf as manuf,sum(distinct so.qty) as shippedOutQty, ma.qty as  orderedQty\r\n"
				+ "	from manufOrders ma left outer join shipOrders so on ma.item = so.item and ma.manuf = so.sender\r\n"
				+ "	group by ma.item, ma.manuf, ma.qty\r\n"
				+ "	order by ma.item, ma.manuf\r\n"
				+ "	;";

		 List<producedVsShipped> producedVsShippedList= jdbcTemplate.query(sql,  new RowMapper<producedVsShipped>() {
			  public producedVsShipped mapRow(ResultSet resultSet, int i) throws SQLException {
				  producedVsShipped  producedVsShipped= new producedVsShipped();
				  producedVsShipped.setManuf(resultSet.getString("manuf"));
				  producedVsShipped.setMatItem(resultSet.getString("item"));
				  producedVsShipped.setOrderedQty(resultSet.getInt("orderedQty"));
				  producedVsShipped.setShippedQty(resultSet.getInt("shippedOutQty"));
				  return producedVsShipped;
			  }
		  });

		return producedVsShippedList;
	}
	
	@Override
	public List<suppliedVsShipped> suppliedVsShipped() {
		// TODO Auto-generated method stub
		final String sql = "select	supl.item as item, supl.supplier as supplier, supl.qty as suppliedQty, sum(distinct ship.qty) as shippedQty\r\n"
				+ "	from supplyOrders supl  left outer join shipOrders ship on supl.item = ship.item and supl.supplier = ship.sender\r\n"
				+ "	group by supl.item, supl.supplier, supl.qty\r\n"
				+ "	order by supl.item, supl.supplier\r\n"
				+ "	;";

		 List<suppliedVsShipped> suppliedVsShippedList= jdbcTemplate.query(sql,  new RowMapper<suppliedVsShipped>() {
			  public suppliedVsShipped mapRow(ResultSet resultSet, int i) throws SQLException {
				  suppliedVsShipped  suppliedVsShipped= new suppliedVsShipped();
				  suppliedVsShipped.setSupplier(resultSet.getString("supplier"));
				  suppliedVsShipped.setItem(resultSet.getString("item"));
				  suppliedVsShipped.setShippedQty(resultSet.getInt("shippedQty"));
				  suppliedVsShipped.setSuppliedQty(resultSet.getInt("suppliedQty"));
				  return suppliedVsShipped;
			  }
		  });

		return suppliedVsShippedList;
	}
	
	@Override
	public List<perSupplierCost> perSupplierCost() {
		// TODO Auto-generated method stub
		final String sql = "select supdi.supplier,\r\n"
				+ "	(case\r\n"
				+ "		when calc.totalcost<supdi.amt1 then calc.totalcost\r\n"
				+ "		when calc.totalcost>supdi.amt2 then ((supdi.amt1+(supdi.amt2-supdi.amt1)*(1-supdi.disc1))+(calc.totalcost - supdi.amt2)*(1-supdi.disc2))\r\n"
				+ "		when calc.totalcost>supdi.amt1 and calc.totalcost<supdi.amt2 then (supdi.amt1+(calc.totalcost - supdi.amt1)*(1-supdi.disc1))\r\n"
				+ "	end) as cost\r\n"
				+ "	from (select supl.supplier as supplier, sum(supl.qty*supup.ppu) as totalcost\r\n"
				+ "		from supplyOrders supl, supplyUnitPricing supup\r\n"
				+ "		where supl.item = supup.item and supl.supplier = supup.supplier\r\n"
				+ "		group by supl.supplier) calc right outer join supplierDiscounts supdi on calc.supplier = supdi.supplier\r\n"
				+ "	order by supdi.supplier\r\n"
				+ "	;";

		 List<perSupplierCost> perSupplierCostList= jdbcTemplate.query(sql,  new RowMapper<perSupplierCost>() {
			  public perSupplierCost mapRow(ResultSet resultSet, int i) throws SQLException {
				  perSupplierCost  perSupplierCost= new perSupplierCost();
				  perSupplierCost.setSupplier(resultSet.getString("supplier"));
				  perSupplierCost.setCost(resultSet.getInt("cost"));
				  return perSupplierCost;
			  }
		  });

		return perSupplierCostList;
	}
	
	@Override
	public List<perManufCost> perManufCost() {
		// TODO Auto-generated method stub
		final String sql = "select mfd.manuf,\r\n"
				+ "	(case\r\n"
				+ "	when calc.totalcost < mfd.amt1 then calc.totalcost\r\n"
				+ "	when calc.totalcost > mfd.amt1 then (mfd.amt1+(calc.totalcost - mfd.amt1)*(1-mfd.disc1))\r\n"
				+ "	end) as cost\r\n"
				+ "	from (select mafo.manuf as manuf, sum(mfup.setUpCost+(mafo.qty*mfup.prodCostPerUnit)) as totalcost\r\n"
				+ "		from manufOrders mafo, manufUnitPricing mfup\r\n"
				+ "		where mafo.item = mfup.prodItem and mafo.manuf = mfup.manuf\r\n"
				+ "		group by mafo.manuf) calc right outer join manufDiscounts mfd on calc.manuf = mfd.manuf\r\n"
				+ "	order by mfd.manuf\r\n"
				+ "	;";

		 List<perManufCost>perManufCostList= jdbcTemplate.query(sql,  new RowMapper<perManufCost>() {
			  public perManufCost mapRow(ResultSet resultSet, int i) throws SQLException {
				  perManufCost  perManufCost= new perManufCost();
				  perManufCost.setManuf(resultSet.getString("manuf"));
				  perManufCost.setCost(resultSet.getInt("cost"));
				  return perManufCost;
			  }
		  });

		return perManufCostList;
	}
}
