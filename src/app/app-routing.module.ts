import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersComponent } from './orders/orders.component'
import { MenusComponent } from './menus/menus.component';
import { OrderDetailsComponent } from './orders/order-details/order-details.component';

const routes: Routes = [
  { path: 'orders', component: OrdersComponent },
  { path: 'menus', component: MenusComponent },
  { path: 'detail/:id', component: OrderDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

export const routingComponents = [OrdersComponent, MenusComponent, OrderDetailsComponent]

// Maybe add OrderDetailsComponent to the routingComponents array

