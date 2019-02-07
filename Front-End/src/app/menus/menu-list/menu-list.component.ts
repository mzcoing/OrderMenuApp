import { Component, OnInit, Input } from '@angular/core';
import { MenuModel } from './../../menu.model';
import { MenuService } from './../../menu.service';


@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  selectedMenu: MenuModel;

  menus: MenuModel[];

  constructor(private menuService: MenuService) { }

  ngOnInit() {
    this.getMenus();
  }

  onSelect(menu: MenuModel): void {
    this.selectedMenu = menu;
  }

  getMenus(): void {
    this.menuService.getMenus()
    .subscribe(menus => this.menus = menus);
  }
}

// , [{title: 'naziv1', price: 1}]