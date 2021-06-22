package commands.menu;

import api.commands.Command;
import controllers.*;
import menu.model.MenuContext;

public final class SaveDataAndExitCommand implements Command {

    private final CustomerController customerController;
    private final ShopController shopController;
    private final ProductController productController;
    private final ShopItemController shopItemController;
    private final OrderController orderController;

    public SaveDataAndExitCommand() {
        customerController = CustomerController.getInstance();
        shopController = ShopController.getInstance();
        productController = ProductController.getInstance();
        shopItemController = ShopItemController.getInstance();
        orderController = OrderController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        MenuContext.setCurrentMenu(null);
        customerController.saveData();
        shopController.saveData();
        productController.saveData();
        shopItemController.saveData();
        orderController.saveData();
    }
}
