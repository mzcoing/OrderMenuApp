import { Component, OnInit } from '@angular/core';
import { OrderModel } from './../../order.model';
import { OrderService } from './../../order.service';
import { ItemClass } from 'src/app/item.model';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  selectedOrder: OrderModel;

  orders: OrderModel[];
  item: ItemClass;

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

  delete(order: OrderModel): void {
    this.orders = this.orders.filter (o => o !== order);
    this.orderService.deleteOrder(order).subscribe();
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {return;}
    this.orderService.addOrder({ name } as OrderModel)
    .subscribe(order => {
      this.orders.push(order);
    });
  }

  // setUsername(){
  //   localStorage.setItem('username', 'user1');
  // }

}