package commands.shopitem;

import api.commands.Command;
import controllers.ProductController;
import controllers.ShopController;
import controllers.ShopItemController;
import model.Product;
import model.Shop;
import model.ShopItem;
import utils.ConsoleUtils;

public final class AddShopItemCommand implements Command {
    private final ShopItemController shopItemController;
    private final ProductController productController;
    private final ShopController shopController;


    public AddShopItemCommand() {
        shopItemController = ShopItemController.getInstance();
        shopController = ShopController.getInstance();
        productController = ProductController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        Shop shop = shopController.get(id);
        System.out.println();
        id = ConsoleUtils.getSelectedEntityId(productController.getAll());
        Product product = productController.get(id);
        Integer amount = new Integer(ConsoleUtils.getInput("amount"));
        Double price = new Double(ConsoleUtils.getInput("price"));
        shopItemController.add(new ShopItem(shop, product, price, amount));
        System.out.println("Successful!");
    }
}
