import { Component, OnInit } from '@angular/core';
import {SupplyChainServiceService} from '../../supply-chain-service.service';
import {Items} from 'src/items'; 
import { ShippedVSCustDemand } from 'src/ShippedVSCustDemand';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-supply-chain',
  templateUrl: './supply-chain.component.html',
  styleUrls: ['./supply-chain.component.css']
})
export class SupplyChainComponent implements OnInit {
   ITEM_DATA:Items[] = [];
   ShippedVSCustDemand:ShippedVSCustDemand[] = [];
   displayColumns: string[] =['items','unitWeight'];

  constructor(private service:SupplyChainServiceService) { }

  ngOnInit(): void {
    this.getAllItems();
    this.getShippedVSCustDemand();
  }

  public getAllItems(){
    let resp = this.service.getItems();
     resp.subscribe(report=> {
      console.log(report);
      this.ITEM_DATA = report;
    });
  }
    public getShippedVSCustDemand(){
      let resp = this.service.getShippedVSCustDemand();
       resp.subscribe(report=> {
        console.log(report);
        this.ShippedVSCustDemand = report;
      });
    
  }
}
