import * as tslib_1 from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
// import { OrdersComponent } from './orders/orders.component';
// import { MenusComponent } from './menus/menus.component';
import { OrderListComponent } from './orders/order-list/order-list.component';
import { MenuListComponent } from './menus/menu-list/menu-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib_1.__decorate([
        NgModule({
            declarations: [
                AppComponent,
                routingComponents,
                // OrdersComponent,
                // MenusComponent,
                OrderListComponent,
                MenuListComponent,
                DashboardComponent,
            ],
            imports: [
                BrowserModule,
                AppRoutingModule,
                FormsModule,
                HttpClientModule
            ],
            providers: [],
            bootstrap: [AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
//# sourceMappingURL=app.module.js.map