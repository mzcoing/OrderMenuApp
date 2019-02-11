package repository;

import models.Item;
import models.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javassist.expr.NewArray;

public class MenuRepository {

    public Map<Integer, Menu> menus;
    public int counter = 0;
    public ArrayList<Item> items;

    public MenuRepository() {
        this.menus = new HashMap<>();
        this.items = new ArrayList<>();

        //  addNewMenu(new Menu(this.getNewId(), "First Menu", new ArrayList<Item>("Milos", "pljeskavica", 5, 15)));
         addNewMenu(new Menu(this.getNewId(), "Second Menu", new ArrayList<>(this.items)));
         addNewMenu(new Menu(this.getNewId(), "Third Menu", new ArrayList<>(this.items)));
         addNewMenu(new Menu(this.getNewId(), "Fourth Menu", new ArrayList<>(this.items)));
        //  addNewMenu(new Menu(this.getNewId(), "Third Menu", new ArrayList()));
        //  addNewMenu(new Menu(this.getNewId(), "Fourth Menu", new ArrayList()));
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
