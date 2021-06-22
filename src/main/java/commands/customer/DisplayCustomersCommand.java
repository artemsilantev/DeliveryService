package commands.customer;

import api.commands.Command;
import controllers.CustomerController;
import utils.ConsoleUtils;

public final class DisplayCustomersCommand implements Command {
    private final CustomerController customerController;

    public DisplayCustomersCommand() {
        customerController = CustomerController.getInstance();
    }

    @Override
    public void execute() {
        System.out.println();
        ConsoleUtils.displayList(customerController.getAll());
    }
}
