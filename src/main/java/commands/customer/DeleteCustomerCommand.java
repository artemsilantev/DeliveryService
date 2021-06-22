package commands.customer;

import api.commands.Command;
import controllers.CustomerController;
import utils.ConsoleUtils;

public final class DeleteCustomerCommand implements Command {
    private final CustomerController customerController;

    public DeleteCustomerCommand() {
        customerController = CustomerController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(customerController.getAll());
        customerController.delete(id);
        System.out.println("Successful!");
    }
}
