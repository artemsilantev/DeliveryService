package commands.order;

import api.commands.Command;
import controllers.OrderController;
import exeptions.NoRecordException;
import utils.ConsoleUtils;

public final class DisplayOrdersCommand implements Command {
    private final OrderController orderController;

    public DisplayOrdersCommand() {
        orderController =OrderController.getInstance();
    }

    @Override
    public void execute() throws NoRecordException {
        System.out.println();
        ConsoleUtils.displayList(orderController.getAll());
    }
}
