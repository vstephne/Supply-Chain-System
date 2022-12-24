import { Component, OnInit } from '@angular/core';
import {SupplyChainServiceService} from '../../supply-chain-service.service';
@Component({
  selector: 'app-item-insert-form',
  templateUrl: './item-insert-form.component.html',
  styleUrls: ['./item-insert-form.component.css']
})
export class ItemInsertFormComponent implements OnInit {

  constructor(private service:SupplyChainServiceService) { }

  ngOnInit(): void {
  }

  public clickFunction(item:String,unitWeight:String){
   this.service.insertItem(item,Number(unitWeight));
  }

}
