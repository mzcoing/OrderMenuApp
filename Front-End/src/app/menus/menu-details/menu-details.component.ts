import { Component, OnInit, Input } from '@angular/core';
import { MenuModel } from './../../menu.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { MenuService } from './../../menu.service';
import { ItemClass } from './../../item.model';
// import { ITEMS } from './../../mock-items';
import { ItemService } from 'src/app/item.service';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  @Input() menu: MenuModel;
  @Input() item: ItemClass;

  items: ItemClass[];

  constructor(
    private route: ActivatedRoute,
    private menuService: MenuService,
    private location: Location,
    private itemService: ItemService
  ) { }

  // items = ITEMS;

  ngOnInit(): void {
    this.getMenu();
    this.getItems();
  }

  getItems(): void {
    this.itemService.getItems()
    .subscribe(items => this.items = items);
  }

  // getMenus(): void {
  //   this.menuService.getMenus()
  //   .subscribe(menus => this.menus = menus);
  // }

  getMenu(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.getMenu(id)
    .subscribe(menu => this.menu = menu);
  }

  goBack(): void {
    this.location.back();
  }

}
