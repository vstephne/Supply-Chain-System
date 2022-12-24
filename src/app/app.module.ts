import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SupplyChainComponent } from './component/supply-chain/supply-chain.component';
import { ItemInsertFormComponent } from './component/item-insert-form/item-insert-form.component';

@NgModule({
  declarations: [
    AppComponent,
    SupplyChainComponent,
    ItemInsertFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
