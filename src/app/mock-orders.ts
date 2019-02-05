import {OrderModel} from './order.model';
import { ItemClass } from './item.model';


 export const ORDERS: OrderModel[] = [
     {id : 1, name: 'First Order', Item: new ItemClass ('Milos', 'Pljeskavica', 2, 120)},
     {id : 2, name: 'Second Order', Item: new ItemClass ('Marko', 'Pizza', 2, 120)},
     {id : 3, name: 'Third Order', Item: new ItemClass ('Nikola', 'Burek', 1, 90)},
     {id : 4, name: 'Fourth Order', Item: new ItemClass ('Jovan', 'Salata', 1, 110)},
     {id : 5, name: 'Fifth Order', Item: new ItemClass ('Pera', 'Burger', 4, 180)},
 ];