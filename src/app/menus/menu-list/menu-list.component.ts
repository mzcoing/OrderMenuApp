import { Component, OnInit } from '@angular/core';
import { MenuModel } from './../../menu.model';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  

  menus: MenuModel[] = [

    new MenuModel(1, 'First Menu'),
    new MenuModel(2, 'Second Menu'),
    new MenuModel(3, 'Third Menu'),
    new MenuModel(4, 'Fourth Menu'),
    new MenuModel(5, 'Fifth Menu')

  ]
  selectedMenu: MenuModel = new MenuModel (0, 'Choose a menu to see the')
  

  constructor() { }

  ngOnInit() {
  }

  onSelect(menu: MenuModel): void {
    this.selectedMenu = menu;
  }
}

// , [{title: 'naziv1', price: 1}]