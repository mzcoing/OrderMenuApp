import { ItemClass } from './item.model';

export class OrderModel{

    id: number;
    name: string;

    constructor(id: number,name: string){
        this.id = id;
        this.name = name;
}
}
// constructor(public id: number, public name: string, public Item: ItemClass){}