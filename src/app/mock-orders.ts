import {OrderModel} from './order.model';
import { ItemClass } from './item.model';

export const ORDERS: OrderModel[] = [
    {id : 1, name: 'First Order', Item: new ItemClass ('asd', 'asd', 5, 5)},
    {id : 2, name: 'Second Order', Item: new ItemClass ('asd', 'asd', 5, 5)},
    {id : 3, name: 'Third Order', Item: new ItemClass ('asd', 'asd', 5, 5)},
    {id : 4, name: 'Fourth Order', Item: new ItemClass ('asd', 'asd', 5, 5)},
    {id : 5, name: 'Fifth Order', Item: new ItemClass ('asd', 'asd', 5, 5)},
];