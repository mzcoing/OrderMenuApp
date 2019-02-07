import { Injectable } from '@angular/core';
import { MenuModel } from './menu.model';
import { MENUS } from './mock-menus';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http: HttpClient) { }

  getMenus(): Observable<MenuModel[]> {

    return of (MENUS);

  }

getMenu(id: number): Observable<MenuModel>{
  return of (MENUS.find(menu => menu.id === id));
  }

}
