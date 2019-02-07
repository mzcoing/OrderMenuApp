package repository;

import models.Menu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MenuRepository {

    private Map<Integer, Menu> menus;

    public MenuRepository() {
        this.menus = new HashMap<>();
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
