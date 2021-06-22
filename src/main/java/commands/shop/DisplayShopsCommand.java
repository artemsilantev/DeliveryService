package commands.shop;

import api.commands.Command;
import controllers.ShopController;
import exeptions.NoRecordException;
import utils.ConsoleUtils;

public final class DisplayShopsCommand implements Command {
    private final ShopController shopController;

    public DisplayShopsCommand() {
        shopController =ShopController.getInstance();
    }

    @Override
    public void execute() throws NoRecordException {
        System.out.println();
        ConsoleUtils.displayList(shopController.getAll());
    }
}
