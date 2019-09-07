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

  menus: MenuModel[] = [];
  items: ItemClass[] = [];
  item: ItemClass;

  ngOnInit(): void {
    this.getMenu();
  }
  getMenu(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.getMenu(id)
    .subscribe(menu => {
      this.menu = menu;
    }

      );
  }

  goBack(): void {
    this.location.back();
  }

  patchItRemove(item: ItemClass): void {

    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.patchRemove(id, item)
    .subscribe(item => this.items = item);
    this.getMenu();

  }

patchItAdd(menuId: number, name: string, price: number){
  if (!name) {
     return;
  }
  const trimmedName = name.trim();
  const newItem = new ItemClass("", trimmedName, 0, price)
  this.menuService.patchAdd(menuId, newItem).subscribe(item => {
     this.items.push(item);
     this.getMenu();
  });
}

save(){
  this.menuService.renameMenu(this.menu.name, this.menu)
  .subscribe(name => this.menu.name = name)
  this.goBack();
}
}

