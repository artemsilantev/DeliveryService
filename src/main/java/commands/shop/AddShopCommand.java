package commands.shop;

import api.commands.Command;
import controllers.CustomerController;
import controllers.ShopController;
import model.Customer;
import model.Shop;
import utils.ConsoleUtils;

public final class AddShopCommand implements Command {
    private final ShopController shopController;

    public AddShopCommand() {
        shopController = ShopController.getInstance();
    }

    @Override
    public void execute() {
        System.out.println();
        Shop shop = new Shop(ConsoleUtils.getInput("name"), ConsoleUtils.getInput("address"),
                ConsoleUtils.getInput("email"));
        shopController.add(shop);
        System.out.println("Successful!");
    }
}
