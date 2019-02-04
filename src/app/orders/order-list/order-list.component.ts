import { Component, OnInit } from '@angular/core';
import { OrderModel } from './../../order.model';
import { ItemClass } from './../../item.model';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders: OrderModel[] = [

      new OrderModel(1, 'First Order', new ItemClass('asd', 'asd', 5, 5)),
      new OrderModel(2, 'Second Order', new ItemClass('asd', 'asd', 5, 5)),
      new OrderModel(3, 'Third Order', new ItemClass('asd', 'asd', 5, 5)),
      new OrderModel(4, 'Fourth Order', new ItemClass('asd', 'asd', 5, 5)),
      new OrderModel(5, 'Fifth Order', new ItemClass('asd', 'asd', 5, 5))

  ]

  selectedOrder: OrderModel;

  constructor() { }

  ngOnInit() {
  }

  onSelect(order: OrderModel): void {
    this.selectedOrder = order;
  }
    
  // onSelect(order: OrderListComponent):void {

  //   this.selectedOrder = order;
  // }

}
