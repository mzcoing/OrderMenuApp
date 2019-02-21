import { Injectable } from '@angular/core';
import { OrderModel } from './order.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ItemClass } from './item.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': 'application/json'})
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

  patchRemove(order: OrderModel | number, itemToRemove: ItemClass): Observable<any> { 
    const name = typeof order === 'string' ? order: itemToRemove.name;
    const id = typeof order === 'number' ? order: order.id;
    const url = `${this.ordersUrl}/remove/${id}/${name}`;

    return this.http.patch(url, itemToRemove, httpOptions).pipe ();
  }

  patchAdd(orderId: number, itemToAdd: ItemClass): Observable<any> { 
    const url = `${this.ordersUrl}/add/${orderId}`;

    return this.http.patch(url, itemToAdd, httpOptions).pipe ();
  }

  renameOrder (name: String, order: OrderModel): Observable<any> {
    const id = typeof order === 'number' ? order: order.id;
    const url = `${this.ordersUrl}/update/${id}`;
    return this.http.patch(url, name, httpOptions);
  }

}