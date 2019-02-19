import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrdersComponent } from './orders/orders.component'
import { MenusComponent } from './menus/menus.component';
import { OrderDetailsComponent } from './orders/order-details/order-details.component';
import { MenuDetailsComponent} from './menus/menu-details/menu-details.component';
import { HomepageComponent } from './Homepage/homepage/homepage.component';

const routes: Routes = [
  { path: 'orders', component: OrdersComponent },
  { path: 'menus', component: MenusComponent },
  { path: 'detail/:id', component: OrderDetailsComponent},
  { path: 'details/:id', component: MenuDetailsComponent},
  { path: 'home', component: HomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

export const routingComponents = [OrdersComponent, MenusComponent, OrderDetailsComponent, MenuDetailsComponent, HomepageComponent]