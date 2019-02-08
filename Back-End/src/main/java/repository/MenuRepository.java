package repository;

import models.Menu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {
    
    private Map<Integer, Menu> menus;

    public MenuRepository() {
        this.menus = new HashMap<>();
        addNewMenu(new Menu(0, "First Menu"));
        addNewMenu(new Menu(1, "Second Menu"));
        addNewMenu(new Menu(2, "Third Menu"));
        addNewMenu(new Menu(3, "Fourth Menu"));
        addNewMenu(new Menu(4, "Fifth Menu"));
        addNewMenu(new Menu(5, "Sixth Menu"));
    }

    public Collection<Menu> getAllMenus() {
        return this.menus.values();
    }

    public Menu get(final int id) {
        return this.menus.get(id);
    }

    public Collection<Menu> addNewMenu(final Menu menu) {

        this.menus.put(menu.getId(), menu);
        return this.menus.values();
        
    }

    public Collection<Menu> removeMenu(final int id) {
        this.menus.remove(id);

        return this.menus.values();
    }

}
