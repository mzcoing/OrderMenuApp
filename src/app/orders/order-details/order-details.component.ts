import { Component, OnInit, Input } from '@angular/core';
import { OrderModel } from './../../order.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { OrderService } from './../../order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  @Input() order: OrderModel;

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getOrder();
  }

  getOrder(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.orderService.getOrder(id)
    .subscribe(order => this.order = order);
  }

  goBack(): void{
    this.location.back();
  }

}
