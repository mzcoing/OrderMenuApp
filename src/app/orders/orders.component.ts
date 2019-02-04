import { Component, OnInit } from '@angular/core';
import { OrderListComponent } from './order-list/order-list.component';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  // selectedOrder: OrderListComponent;

  constructor() { }

  ngOnInit() {
  }

  // onSelect(order: OrderListComponent):void {

  //   this.selectedOrder = order;
  // }

}
