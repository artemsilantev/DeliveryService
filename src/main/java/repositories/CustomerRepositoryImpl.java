package repositories;

import api.data.CustomerDataStorage;
import api.repositories.CustomerRepository;
import model.Customer;
import storages.CustomerDataStorageImpl;

public final class CustomerRepositoryImpl extends AbstractRepositoryImpl<Customer>
    implements CustomerRepository {

    private static CustomerRepositoryImpl instance;

    public static CustomerRepositoryImpl getInstance(){
        return instance == null ? instance = new CustomerRepositoryImpl(CustomerDataStorageImpl.getInstance())
                : instance;
    }

    private CustomerRepositoryImpl(CustomerDataStorage customerDataStorage) {
        super(customerDataStorage);
    }
}
