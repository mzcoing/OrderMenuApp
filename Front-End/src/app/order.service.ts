import { Injectable } from '@angular/core';
import { OrderModel } from './order.model';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class OrderService {

  private ordersUrl = 'http://localhost:8080/order';

  constructor(private http: HttpClient) { }

  getOrders(): Observable<OrderModel[]> {

    return this.http.get<OrderModel[]>(this.ordersUrl)
    .pipe(

    );

  }
getOrder(id: number): Observable<OrderModel>{
  const url = `${this.ordersUrl}/${id}`;
  return this.http.get<OrderModel>(url)
  }

  deleteOrder(order: OrderModel | number): Observable<OrderModel> {
    const id = typeof order === 'number' ? order: order.id;
    const url = `${this.ordersUrl}/${id}`;

    return this.http.delete<OrderModel>(url, httpOptions).pipe(

    );
  }

  addOrder (order: OrderModel): Observable<OrderModel> {
    return this.http.post<OrderModel>(this.ordersUrl, order, httpOptions)
  }

}