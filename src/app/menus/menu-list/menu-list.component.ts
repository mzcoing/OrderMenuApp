import { Component, OnInit } from '@angular/core';
import { MenuModel } from './../../menu.model';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  menus: MenuModel[] = [

    new MenuModel(1, 'First Menu', [{title: 'naziv', price: 123}])

  ]

  constructor() { }

  ngOnInit() {
  }

}
