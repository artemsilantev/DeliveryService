package commands.shopitem;

import api.commands.Command;
import controllers.ShopController;
import controllers.ShopItemController;
import model.ShopItem;
import utils.ConsoleUtils;

import java.util.List;

public final class EditShopItemCommand implements Command {

    private final ShopItemController shopItemController;
    private final ShopController shopController;


    public EditShopItemCommand() {
        shopItemController = ShopItemController.getInstance();
        shopController = ShopController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        List<ShopItem> items = shopItemController.getByShop(shopController.get(id));
        id = ConsoleUtils.getSelectedEntityId(items);
        ShopItem shopItem = shopItemController.get(id);
        Integer amount = new Integer(ConsoleUtils.getInput("amount"));
        Double price = new Double(ConsoleUtils.getInput("price"));
        shopItem.setAmount(amount);
        shopItem.setPrice(price);
        shopItemController.update(shopItem);
        System.out.println("Successful!");
    }
}
