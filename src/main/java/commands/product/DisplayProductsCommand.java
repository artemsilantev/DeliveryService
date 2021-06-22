package commands.product;

import api.commands.Command;
import controllers.ProductController;
import utils.ConsoleUtils;

public final class DisplayProductsCommand implements Command {
    private final ProductController productController;

    public DisplayProductsCommand() {
        productController = ProductController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        ConsoleUtils.displayList(productController.getAll());
    }
}
