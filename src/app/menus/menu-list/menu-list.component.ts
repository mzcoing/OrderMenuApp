import { Component, OnInit } from '@angular/core';
import { MenuModel } from './../../menu.model';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  menus: MenuModel[] = [

    new MenuModel(1, 'First Menu', [{title: 'naziv1', price: 1}]),
    new MenuModel(2, 'Second Menu', [{title: 'naziv2', price: 12}]),
    new MenuModel(3, 'Third Menu', [{title: 'naziv3', price: 123}]),
    new MenuModel(4, 'Fourth Menu', [{title: 'naziv4', price: 1234}]),
    new MenuModel(5, 'Fifth Menu', [{title: 'naziv5', price: 1235}])

  ]

  selectedMenu: MenuModel;

  constructor() { }

  ngOnInit() {
  }

  onSelect(menu: MenuModel): void {
    this.selectedMenu = menu;
  }
}
