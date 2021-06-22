package commands.shopitem;

import api.commands.Command;
import controllers.ShopController;
import controllers.ShopItemController;
import model.ShopItem;
import utils.ConsoleUtils;
import java.util.List;
public final class DeleteShopItemCommand implements Command {
    private final ShopItemController shopItemController;
    private final ShopController shopController;

    public DeleteShopItemCommand(){
        shopItemController = ShopItemController.getInstance();
        shopController = ShopController.getInstance();
    }


    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        List<ShopItem> items = shopItemController.getByShop(shopController.get(id));
        System.out.println("Please select shop item to delete: ");
        id = ConsoleUtils.getSelectedEntityId(items);
        shopItemController.delete(id);
        System.out.println("Successful!");
    }
}
