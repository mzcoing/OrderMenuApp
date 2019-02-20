import { Component, OnInit, Input } from '@angular/core';
import { OrderModel } from './../../order.model';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { OrderService } from './../../order.service';
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
    private route: ActivatedRoute,
    private orderService: OrderService,
    private location: Location
  ) { }

  items: ItemClass[] = [];
  item: ItemClass;
  totalamount: number;
  selectedMenu: MenuModel;
  menus: MenuModel[] = [];
  orders: OrderModel[] = [];
  menu: MenuModel;

  getTotal(){
    let total = 0;
    for (var i = 0; i<this.order.items.length; i++) {
      if (this.order.items[i].price){
        total+= this.order.items[i].price*this.order.items[i].quantity;
        this.totalamount = total;
      }
    }
    return total;
  }

  ngOnInit(): void {
    this.getOrder();
    this.getMenus();
    
  }
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

  patchItRemove(item: ItemClass): void {

    const id = +this.route.snapshot.paramMap.get('id');
    this.orderService.patchRemove(id, item)
    .subscribe(item => this.items = item);
    window.location.reload();

  }

  

  patchItAdd(menuId: number, name: string, price: number){
    const newItem = new ItemClass(localStorage.getItem('username'), name, 1, price)
    this.orderService.patchAdd(menuId, newItem).subscribe(item => {
       this.items.push(item);
       window.location.reload();
    });
  }

  save(){
    this.orderService.renameOrder(this.order.name, this.order)
    .subscribe(name => this.order.name = name);
    this.goBack();
  }



}
