import { ItemClass } from './item.model';

export class MenuModel {


id: number;
name: string;
items: ItemClass[];
    constructor( id: number,  name: string, items: ItemClass[]){

         this.id = id;
         this.name = name;
         this.items = items;
          //this.MenuItem{this.title, this.price} = MenuItem;

    }


}

 //MenuItem: Array<{title: string, price: number}>