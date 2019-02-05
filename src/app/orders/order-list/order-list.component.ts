import { Component, OnInit } from '@angular/core';
import { OrderModel } from './../../order.model';
import { OrderService } from './../../order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  selectedOrder: OrderModel;

  orders: OrderModel[];

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getOrders();
  }
  onSelect(order: OrderModel): void {
    this.selectedOrder = order;
  }
  getOrders(): void {

    this.orderService.getOrders()
    .subscribe(orders => this.orders = orders);

  }
  

    
  // onSelect(order: OrderListComponent):void {

  //   this.selectedOrder = order;
  // }

}