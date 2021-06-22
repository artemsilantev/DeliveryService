package api.services;

import model.Customer;
import java.io.IOException;

public interface CustomerService extends AbstractService<Customer> {
    void saveData() throws IOException;
}
