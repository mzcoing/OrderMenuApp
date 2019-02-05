import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient, HttpHeaders} from '@angular/common/http';

import { AppComponent } from './app.component';
import { OrderListComponent } from './orders/order-list/order-list.component';
import { MenuListComponent } from './menus/menu-list/menu-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OrderDetailsComponent } from './orders/order-details/order-details.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    OrderListComponent,
    MenuListComponent,
    DashboardComponent,
    OrderDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
