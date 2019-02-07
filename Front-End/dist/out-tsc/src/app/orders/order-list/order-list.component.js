import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { OrderModel } from './../../order.model';
import { ItemClass } from './../../item.model';
var OrderListComponent = /** @class */ (function () {
    function OrderListComponent() {
        this.orders = [
            new OrderModel(1, 'First Order', new ItemClass('asd', 'asd', 5, 5)),
            new OrderModel(2, 'Second Order', new ItemClass('asd', 'asd', 5, 5)),
            new OrderModel(3, 'Third Order', new ItemClass('asd', 'asd', 5, 5)),
            new OrderModel(4, 'Fourth Order', new ItemClass('asd', 'asd', 5, 5)),
            new OrderModel(5, 'Fifth Order', new ItemClass('asd', 'asd', 5, 5))
        ];
    }
    OrderListComponent.prototype.ngOnInit = function () {
    };
    OrderListComponent.prototype.onSelect = function (order) {
        this.selectedOrder = order;
    };
    OrderListComponent = tslib_1.__decorate([
        Component({
            selector: 'app-order-list',
            templateUrl: './order-list.component.html',
            styleUrls: ['./order-list.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], OrderListComponent);
    return OrderListComponent;
}());
export { OrderListComponent };
//# sourceMappingURL=order-list.component.js.map