package repository;

import models.Item;
import models.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {

    public Map<Integer, Menu> menus;
    public int counter = 0;
    ArrayList<Item> items = new ArrayList<>();

    public MenuRepository() {
        this.menus = new HashMap<>();
        for (int i=1; i<9; i++) {
            Item item = new Item("Item " + i, i+200);

            this.items.add(item);
        }

        addNewMenu(new Menu(this.getNewId(), "First Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Second Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Third Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Fourth Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Fifth Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Sixth Menu", this.items));
        addNewMenu(new Menu(this.getNewId(), "Seventh Menu", this.items));
       
    }
 
    private int getNewId() {
        return counter++;
    }

    public Collection<Menu> getAllMenus() {
        return this.menus.values();
    }

    public Menu get(final int id) {
        return this.menus.get(id);
    }
 
    public Collection<Menu> addNewMenu(final Menu menu) {
        menu.setId(this.getNewId());

        this.menus.put(menu.getId(), menu);

        return this.menus.values();
    } 

    public Collection<Menu> removeMenu(final int id) {
        this.menus.remove(id);

        return this.menus.values();
    }

}
