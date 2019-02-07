import { Injectable } from '@angular/core';
import { OrderModel } from './order.model';
import { ORDERS } from './mock-orders';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  getOrders(): Observable<OrderModel[]> {

    return of (ORDERS);

  }

getOrder(id: number): Observable<OrderModel>{
  return of (ORDERS.find(order => order.id === id));
  }

}
