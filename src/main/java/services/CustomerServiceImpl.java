package services;

import api.repositories.CustomerRepository;
import api.services.CustomerService;
import model.Customer;
import repositories.CustomerRepositoryImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;

public final class CustomerServiceImpl extends AbstractServiceImpl<Customer>
        implements CustomerService {

    private static CustomerServiceImpl instance;

    private CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    public static CustomerServiceImpl getInstance() {
        return instance == null ? instance = new CustomerServiceImpl(CustomerRepositoryImpl.getInstance())
                : instance;
    }


    @Override
    public Customer create(Customer entity) {
        for (Customer customer : abstractRepository.getAll()) {
            if (customer.getEmail().equals(entity.getEmail())) {
                entity.setId(customer.getId());
                return entity;
            }
        }
       return super.create(entity);
    }

    @Override
    public void saveData() throws IOException {
        String json = JsonUtils.getSerializedEntity(abstractRepository.getAll());
        FileUtils.createNewFile(FileUtils.getCustomerDataFileName());
        FileUtils.writeToFile(FileUtils.getCustomerDataFileName(), json);
    }
}
