package storages;

import api.data.CustomerDataStorage;
import model.Customer;

import java.util.ArrayList;

public final class CustomerDataStorageImpl extends AbstractDataStorageImpl<Customer>
        implements CustomerDataStorage {

    private CustomerDataStorageImpl() {

    }

    private static CustomerDataStorageImpl instance;

    public static CustomerDataStorageImpl getInstance() {
        return instance == null ? instance = new CustomerDataStorageImpl()
                : instance;
    }

}
