import { ItemClass } from './item.model';

export class OrderModel{

    constructor(public id: number, public name: string, public Item: ItemClass){}
}