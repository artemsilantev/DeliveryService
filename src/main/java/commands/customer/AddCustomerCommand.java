package commands.customer;

import api.commands.Command;
import controllers.CustomerController;
import model.Customer;
import utils.ConsoleUtils;

public final class AddCustomerCommand implements Command {

    private final CustomerController customerController;

    public  AddCustomerCommand() {
        customerController = CustomerController.getInstance();
    }

    @Override
    public void execute() {
       Customer customer = new Customer(ConsoleUtils.getInput("first name"),ConsoleUtils.getInput("second name"),
               ConsoleUtils. getInput("telephone number"), ConsoleUtils.getInput("email"),
               ConsoleUtils. getInput("address"));
        customerController.add(customer);
        System.out.println("Successful!");
    }
}
