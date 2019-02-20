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

  add(name: string): void {
    name = name.trim();
    if (!name) {return;}
    this.menuService.addMenu({ name } as MenuModel)
    .subscribe(menu => {
      this.menus.push(menu);
      window.location.reload();
    });
  }

  delete(menu: MenuModel): void {
    this.menus = this.menus.filter(m => m !== menu);
    this.menuService.deleteMenu(menu).subscribe();
  }
}