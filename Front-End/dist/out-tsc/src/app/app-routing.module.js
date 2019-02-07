import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { OrdersComponent } from './orders/orders.component';
import { MenusComponent } from './menus/menus.component';
var routes = [
    { path: 'orders', component: OrdersComponent },
    { path: 'menus', component: MenusComponent },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());
export { AppRoutingModule };
export var routingComponents = [OrdersComponent, MenusComponent];
//# sourceMappingURL=app-routing.module.js.map