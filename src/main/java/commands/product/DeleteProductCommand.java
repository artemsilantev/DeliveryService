package commands.product;

import api.commands.Command;
import controllers.ProductController;
import controllers.ShopItemController;
import model.ShopItem;
import utils.ConsoleUtils;

import java.util.List;

public  final class DeleteProductCommand implements Command {
    private final ProductController productController;
    private final ShopItemController shopItemController;

    public DeleteProductCommand() {
        productController = ProductController.getInstance();
        shopItemController = ShopItemController.getInstance();
    }


    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(productController.getAll());
        List<ShopItem> shopItemToDelete = shopItemController.getByProduct(productController.get(id));
        shopItemController.getAll().removeAll(shopItemToDelete);
        productController.delete(id);
        System.out.println("Successful!");
    }
}
