import { Injectable } from '@angular/core';
import { MenuModel } from './menu.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ItemClass } from './item.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class MenuService {

  private menusUrl = 'http://localhost:8080/menu';

  constructor(private http: HttpClient) { }

  getMenus(): Observable<MenuModel[]> {

    return this.http.get<MenuModel[]>(this.menusUrl)
    .pipe(
    );

  }

  getMenu(id: number): Observable<MenuModel>{
  const url = `${this.menusUrl}/${id}`;
  return this.http.get<MenuModel>(url)
  }

  addMenu (menu: MenuModel): Observable<MenuModel> {
    return this.http.post<MenuModel>(this.menusUrl, menu, httpOptions)
  }

  deleteMenu (menu: MenuModel | number): Observable<MenuModel> {
    const id = typeof menu === 'number' ? menu: menu.id;
    const url = `${this.menusUrl}/${id}`;

    return this.http.delete<MenuModel>(url, httpOptions).pipe(
    );
  }

  // deleteItem (item: ItemClass): Observable<MenuModel> {
  //   // const url = `${this.menusUrl}/${id}`;
  //   return this.http.patch<MenuModel>(this.menusUrl, item, httpOptions)
  // }

  // updateMenu (menu: MenuModel): Observable<any> {
  //   return this.http.patch(this.menusUrl, menu, httpOptions).pipe()
  // }

}
