export class MenuModel {

    public MenuItem = Array<{title: string, price: number}>();
    id: number;
    name: string;

    constructor(id: number, name: string, MenuItem: Array<{title: string, price: number}>){

        this.id = id;
        this.name = name;
        this.MenuItem = MenuItem;

    }


}