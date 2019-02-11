import { Injectable } from '@angular/core';
import { OrderModel } from './order.model';
// import { ORDERS } from './mock-orders';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

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
    // return of (ORDERS);

  }
getOrder(id: number): Observable<OrderModel>{
  const url = `${this.ordersUrl}/${id}`;
  return this.http.get<OrderModel>(url)

  // return of (ORDERS.find(order => order.id === id));
  }

  deleteOrder(order: OrderModel | number): Observable<OrderModel> {
    const id = typeof order === 'number' ? order: order.id;
    const url = `${this.ordersUrl}/${id}`;

    return this.http.delete<OrderModel>(url, httpOptions).pipe(

    );
  }

}