import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Items } from 'src/items';
import { ShippedVSCustDemand } from 'src/ShippedVSCustDemand';

@Injectable({
  providedIn: 'root'
})
export class SupplyChainServiceService {

  constructor(private http:HttpClient) { }
 
  public getItems(){  
      return this.http.get<Items[]>("http://localhost:8080/getItems");
  }

  public getShippedVSCustDemand(){  
    return this.http.get<ShippedVSCustDemand[]>("http://localhost:8080/getShippedVSCustDemand");
  }

  public insertItem(item:String,unitWeight:Number){ 
    const itemData = {
      "item":item,
      "unitWeight":unitWeight
  }; 
  const headers = { 'content-type': 'application/json'}  
  const body=JSON.stringify(itemData);
    this.http.post<any>('https://localhost:8080/insertItem', body,{'headers':headers});
  }
}
