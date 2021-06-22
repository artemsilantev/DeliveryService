package intitalizers;

import api.commands.Command;
import api.initializers.Initializer;
import commands.customer.*;
import commands.menu.*;
import commands.order.*;
import commands.product.*;
import commands.shop.*;
import commands.shopitem.*;
import menu.model.Menu;
import menu.model.MenuContext;
import menu.model.MenuItem;

import java.util.List;
import java.util.ArrayList;

public final class MenuInitializer implements Initializer {

    private MenuInitializer(){}

    private static MenuInitializer instance;

    public static MenuInitializer getInstance(){
        return instance == null ? instance = new MenuInitializer()
                :instance;
    }


    @Override
    public void init() {
        MenuContext.setCurrentMenu(getMainMenu());
    }

    private Menu getMainMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items,null);
        addMenuItemToList("Customers menu", new ChangeToNextMenuCommand(getCustomerMenu()), items);
        addMenuItemToList("Shops menu", new ChangeToNextMenuCommand(getShopMenu()), items);
        addMenuItemToList("Products menu", new ChangeToNextMenuCommand(getProductMenu()), items);
        addMenuItemToList("Shop items menu", new ChangeToNextMenuCommand(getShopItemMenu()), items);
        addMenuItemToList("Order menu", new ChangeToNextMenuCommand(getOrderMenu()), items);
        addMenuItemToList("Save and exit", new SaveDataAndExitCommand(), items);
        return menu;
    }

    private Menu getCustomerMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items, null);
        addMenuItemToList("Add customer", new AddCustomerCommand(), items);
        addMenuItemToList("Edit customer", new EditCustomerCommand(), items);
        addMenuItemToList("Delete customer", new DeleteCustomerCommand(), items);
        addMenuItemToList("Display customers", new DisplayCustomersCommand(), items);
        addMenuItemToList("Back", new ChangeToPreviousMenuCommand(), items);
        return menu;
    }

    private Menu getShopMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items, null);
        addMenuItemToList("Add shop", new AddShopCommand(), items);
        addMenuItemToList("Edit shop", new EditShopCommand(), items);
        addMenuItemToList("Delete shop", new DeleteShopCommand(), items);
        addMenuItemToList("Display shops", new DisplayShopsCommand(), items);
        addMenuItemToList("Back", new ChangeToPreviousMenuCommand(), items);
        return menu;
    }

    private Menu getProductMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items, null);
        addMenuItemToList("Add product", new AddProductCommand(), items);
        addMenuItemToList("Edit product", new EditProductCommand(), items);
        addMenuItemToList("Delete product", new DeleteProductCommand(), items);
        addMenuItemToList("Display products", new DisplayProductsCommand(), items);
        addMenuItemToList("Back", new ChangeToPreviousMenuCommand(), items);
        return menu;
    }

    private Menu getShopItemMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items,null);
        addMenuItemToList("Add shop item", new AddShopItemCommand(), items);
        addMenuItemToList("Edit shop item", new EditShopItemCommand(), items);
        addMenuItemToList("Delete shop item", new DeleteShopItemCommand(), items);
        addMenuItemToList("Display shop items by attributes", new DisplayShopItemsByKeysCommand(), items);
        addMenuItemToList("Display shop item", new DisplayShopItemsCommand(), items);
        addMenuItemToList("Back", new ChangeToPreviousMenuCommand(), items);
        return menu;
    }

    private Menu getOrderMenu(){
        ArrayList<MenuItem> items = new ArrayList<>();
        Menu menu = new Menu(items,null);
        addMenuItemToList("Add order", new AddOrderCommand(), items);
        addMenuItemToList("Display orders", new DisplayOrdersCommand(), items);
        addMenuItemToList("Back", new ChangeToPreviousMenuCommand(), items);
        return menu;
    }

    private void addMenuItemToList(String title, Command command, List<MenuItem> list){
        list.add(new MenuItem(title,command));
    }
}
