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
  // @Input() itema: ItemClass;

  constructor(
    private route: ActivatedRoute,
    private menuService: MenuService,
    private location: Location,
  ) { }

  menus: MenuModel[] = [];
  items: ItemClass[] = [];
  item: ItemClass;
  // item: ItemClass;

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

  patchItRemove(item: ItemClass): void {

    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.patchRemove(id, item)
    .subscribe(item => this.items = item);

  }

  // patchItAdd(item: ItemClass): void {

  //   const id = +this.route.snapshot.paramMap.get('id');
  //   this.menuService.patchAdd(id, item)
  //   .subscribe(item => this.items = item);

  // }

  patchItAdd(name: string, price: number){
    name = name.trim();
    if (!name) {return;}
    const id = +this.route.snapshot.paramMap.get('id');
    this.menuService.patchAdd(id, this.item)
    //With this ^^ , the value is null, but new element is added to the array. Cannot read property push of undefined. PATCH is triggered on the backend.
    // this.menuService.patchAdd(id, {name, price} as ItemClass) ----- Three errors, nothing happens
    .subscribe(item => {
      this.items.push(item);
    });
  }}
  // }
    // const id = +this.route.snapshot.paramMap.get('id');
    // this.menuService.addItem({id, item} as MenuModel)
    // .subscribe(() => console.log("OK"));
  // deleteItem(): void {
  //   this.menuService.deleteItem(this.item)
  //   .subscribe(item => this.item = item);

  // }




  // save(): void {
  //   this.menuService.updateMenu(this.menu)
  //   .subscribe(() => this.goBack());
  // }



