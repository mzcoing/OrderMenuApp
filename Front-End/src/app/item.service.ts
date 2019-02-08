import { Injectable } from '@angular/core';
import { ItemClass } from './item.model';
// import { MENUS } from './mock-menus';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class ItemService {

  private itemsUrl = 'http://localhost:8080/item';

  constructor(private http: HttpClient) { }

  getItems(): Observable<ItemClass[]> {

    return this.http.get<ItemClass[]>(this.itemsUrl)
    .pipe(
      // map(response => response)
    );
    //return of (MENUS);

  }

}
