import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersComponent } from './orders/orders.component'
import { MenusComponent } from './menus/menus.component';

const routes: Routes = [
  { path: 'orders', component: OrdersComponent },
  { path: 'menus', component: MenusComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
export const routingComponents = [OrdersComponent, MenusComponent]

