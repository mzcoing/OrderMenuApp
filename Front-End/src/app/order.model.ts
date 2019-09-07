import { ItemClass } from './item.model';

export class OrderModel{

    id: number;
    name: string;
    // menuid: number;
    items: ItemClass[];

    constructor(id: number,name: string, items: ItemClass[]){
        this.id = id;
        this.name = name;
        // this.menuid = menuid;
        this.items = items;
    }
}