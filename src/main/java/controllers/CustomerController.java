package controllers;

import api.services.CustomerService;
import exeptions.NoRecordException;
import model.Customer;
import services.CustomerServiceImpl;

import java.io.IOException;

import java.util.List;

public class CustomerController {
    private final CustomerService customerService;
    private static CustomerController instance;

    public static CustomerController getInstance() {
        return instance == null ? instance = new CustomerController()
                : instance;
    }

    private CustomerController() {
        customerService = CustomerServiceImpl.getInstance();
    }

    public Customer add(Customer customer) {
        return customerService.create(customer);
    }

    public void update(Customer customer) {
        customerService.update(customer);
    }

    public List<Customer> getAll() {
        return customerService.getAll();
    }

    public void saveData() throws IOException {
        customerService.saveData();
    }

    public void delete(Long id) throws NoRecordException {
        customerService.delete(id);
    }

    public Customer get(Long id) throws NoRecordException {
        return customerService.get(id);
    }

}
