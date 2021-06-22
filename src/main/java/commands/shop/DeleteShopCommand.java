package commands.shop;

import api.commands.Command;
import controllers.ShopController;
import controllers.ShopItemController;
import model.ShopItem;
import utils.ConsoleUtils;
import java.util.List;

public final class DeleteShopCommand implements Command {
    private final ShopController shopController;
    private final ShopItemController shopItemController;

    public DeleteShopCommand() {

        shopController =ShopController.getInstance();
        shopItemController= ShopItemController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        List<ShopItem> shopItemToDelete = shopItemController.getByShop(shopController.get(id));
        shopItemController.getAll().removeAll(shopItemToDelete);
        shopController.delete(id);
        System.out.println("Successful!");
    }
}
