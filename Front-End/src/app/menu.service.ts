import { Injectable } from '@angular/core';
import { MenuModel } from './menu.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ItemClass } from './item.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Accept': 'application/json'})
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

  patchRemove(menu: MenuModel | number, itemToRemove: ItemClass): Observable<any> { 
    const name = typeof menu === 'string' ? menu: itemToRemove.name;
    const id = typeof menu === 'number' ? menu: menu.id;
    const url = `${this.menusUrl}/remove/${id}/${name}`;

    return this.http.patch<any>(url, itemToRemove, httpOptions).pipe ()
  }

  patchAdd(menuId: number, itemToAdd: ItemClass): Observable<any> { 
    const url = `${this.menusUrl}/add/${menuId}`;

    return this.http.patch(url, itemToAdd, httpOptions).pipe ()
  }

  renameMenu (name: String, menu: MenuModel): Observable<any> {
    const id = typeof menu === 'number' ? menu: menu.id;
    const url = `${this.menusUrl}/update/${id}`;
    return this.http.patch(url, name, httpOptions);
  }
}
