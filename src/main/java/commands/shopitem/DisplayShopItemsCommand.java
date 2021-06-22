package commands.shopitem;

import api.commands.Command;
import controllers.ShopItemController;
import utils.ConsoleUtils;

public  final class DisplayShopItemsCommand implements Command {
    private final ShopItemController shopItemController;

    public DisplayShopItemsCommand() {
        shopItemController = ShopItemController.getInstance();

    }
    @Override
    public void execute() throws Exception {
        System.out.println();
        ConsoleUtils.displayList(shopItemController.getAll());
    }
}
