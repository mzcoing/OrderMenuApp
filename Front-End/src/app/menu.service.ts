import { Injectable } from '@angular/core';
import { MenuModel } from './menu.model';
// import { MENUS } from './mock-menus';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

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
      // map(response => response)
    );
    //return of (MENUS);

  }

getMenu(id: number): Observable<MenuModel>{
  const url = `${this.menusUrl}/${id}`;
  return this.http.get<MenuModel>(url)
  // return of (MENUS.find(menu => menu.id === id));
  }

  addMenu (menu: MenuModel): Observable<MenuModel> {
    return this.http.post<MenuModel>(this.menusUrl, menu, httpOptions)
  }


}
