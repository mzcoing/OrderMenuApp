import { Component, OnInit, Input } from '@angular/core';
import { MenuModel } from './../../menu.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { MenuService } from './../../menu.service';
import { ItemClass } from './../../item.model';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  @Input() menu: MenuModel;

  constructor(
    private route: ActivatedRoute,
    private menuService: MenuService,
    private location: Location,
  ) { }

  menus: MenuModel[];
  items: ItemClass[];

  ngOnInit(): void {
    this.getMenu();
  }
  getMenu(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.getMenu(id)
    .subscribe(menu => this.menu = menu);
  }

  goBack(): void {
    this.location.back();
  }
}
