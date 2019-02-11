import { Component, OnInit, Input } from '@angular/core';
import { OrderModel } from './../../order.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { OrderService } from './../../order.service';
// import { ItemService } from './../../item.service';
import { MenuModel } from './../../menu.model';
import { MenuService } from './../../menu.service';
import { ItemClass } from 'src/app/item.model';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  @Input() order: OrderModel;

  constructor(
    private menuService: MenuService,
    // private itemService: ItemService,
    private route: ActivatedRoute,
    private orderService: OrderService,
    private location: Location
  ) { }

  items: ItemClass[];
  totalamount: number;
  selectedMenu: MenuModel;
  menus: MenuModel[];

  getTotal(){
    let total = 0;
    for (var i = 0; i<this.items.length; i++) {
      if (this.items[i].price){
        total+= this.items[i].price*this.items[i].quantity;
        this.totalamount = total;
      }
    }
    return total;
  }

  ngOnInit(): void {
    this.getOrder();
    this.getMenus();
    // this.getItems();
  }

  // getItems(): void {
  //   this.itemService.getItems()
  //   .subscribe(items => this.items = items);
  // }
  getOrder(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.orderService.getOrder(id)
    .subscribe(order => this.order = order);
  }

  goBack(): void{
    this.location.back();
  }

  onSelect(menu: MenuModel): void {
    this.selectedMenu = menu;
  }

  getMenus(): void {
    this.menuService.getMenus()
    .subscribe(menus => this.menus = menus);
  }

}
