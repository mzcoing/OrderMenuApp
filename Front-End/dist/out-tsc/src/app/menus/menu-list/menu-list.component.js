import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { MenuModel } from './../../menu.model';
var MenuListComponent = /** @class */ (function () {
    function MenuListComponent() {
        this.menus = [
            new MenuModel(1, 'First Menu'),
            new MenuModel(2, 'Second Menu'),
            new MenuModel(3, 'Third Menu'),
            new MenuModel(4, 'Fourth Menu'),
            new MenuModel(5, 'Fifth Menu')
        ];
    }
    MenuListComponent.prototype.ngOnInit = function () {
    };
    MenuListComponent.prototype.onSelect = function (menu) {
        this.selectedMenu = menu;
    };
    MenuListComponent = tslib_1.__decorate([
        Component({
            selector: 'app-menu-list',
            templateUrl: './menu-list.component.html',
            styleUrls: ['./menu-list.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], MenuListComponent);
    return MenuListComponent;
}());
export { MenuListComponent };
// , [{title: 'naziv1', price: 1}]
//# sourceMappingURL=menu-list.component.js.map