// import { Injectable } from '@angular/core';
// import { ItemClass } from './item.model';
// // import { MENUS } from './mock-menus';
// import { Observable, of } from 'rxjs';
// import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { catchError, map, tap } from 'rxjs/operators';

// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'application/json'})
// };

// @Injectable({
//   providedIn: 'root'
// })

// export class ItemService {

//   private itemsUrl = 'http://localhost:8080/item';

//   constructor(private http: HttpClient) { }

//   getItems(): Observable<ItemClass[]> {

//     return this.http.get<ItemClass[]>(this.itemsUrl)
//     .pipe(
//       // map(response => response)
//     );
//     //return of (MENUS);

//   }

//   deleteItem (item: ItemClass | number): Observable<ItemClass> {
//     const id = typeof item === 'number' ? item: item.id;
//     const url = `${this.itemsUrl}/${id}`;

//     return this.http.delete<ItemClass>(url, httpOptions);
//   }

// }
