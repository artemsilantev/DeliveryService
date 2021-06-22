package commands.shop;

import api.commands.Command;
import controllers.ShopController;
import model.Shop;
import utils.ConsoleUtils;

public  final class EditShopCommand implements Command {
    private final ShopController shopController;

    public EditShopCommand() {
        shopController =ShopController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        Shop shop = shopController.get(id);
        shop.setName(ConsoleUtils.getInput("name"));
        shop.setAddress(ConsoleUtils.getInput("address"));
        shop.setEmail(ConsoleUtils.getInput("email"));
        shopController.update(shop);
        System.out.println("Successful!");
    }
}
