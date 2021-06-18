package storages;

import api.data.CustomerDataStorage;
import model.Customer;

public class CustomerDataStorageImpl extends AbstractDataStorageImpl<Customer>
        implements CustomerDataStorage {

    private CustomerDataStorageImpl() {
    }

    private static CustomerDataStorageImpl instance;

    public static CustomerDataStorageImpl getInstance() {
        if (instance == null) {
            instance = new CustomerDataStorageImpl();
        }
        return instance;
    }

}
