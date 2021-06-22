package commands.customer;

import api.commands.Command;
import controllers.CustomerController;
import model.Customer;
import utils.ConsoleUtils;

public final class EditCustomerCommand implements Command {

    private final CustomerController customerController;

    public EditCustomerCommand() {
        customerController = CustomerController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        Long id = ConsoleUtils.getSelectedEntityId(customerController.getAll());
        Customer customer = customerController.get(id);
        customer.setFirstName(ConsoleUtils.getInput("first name"));
        customer.setSecondName(ConsoleUtils.getInput("second name"));
        customer.setNumber(ConsoleUtils.getInput("telephone number"));
        customer.setEmail(ConsoleUtils.getInput("email"));
        customer.setAddress(ConsoleUtils.getInput("address"));
        customerController.update(customer);
        System.out.println("Successful!");
    }

}
