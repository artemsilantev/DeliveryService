package intitalizers;

import api.data.CustomerDataStorage;
import api.initializers.Initializer;
import com.google.gson.reflect.TypeToken;
import model.Customer;
import storages.CustomerDataStorageImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public final class CustomerDataInitializer implements Initializer {
    private static CustomerDataInitializer instance;
    private final CustomerDataStorage customerDataStorage;

    private CustomerDataInitializer() {
        customerDataStorage = CustomerDataStorageImpl.getInstance();
    }

    public static CustomerDataInitializer getInstance() {
        return instance == null ? instance = new CustomerDataInitializer()
                : instance;
    }


    @Override
    public void init() {
        try {
            String json = FileUtils.readInfo(FileUtils.getCustomerDataFileName());
            List<Customer> customers = JsonUtils.deserializeList(json, new TypeToken<List<Customer>>() {
            }.getType());
            if (customers == null || customers.size()==0) {
                setupDataStorage(new ArrayList<>(), 0L);
                return;
            }
            setupDataStorage(customers, customers.get(customers.size() - 1).getId() + 1);
        } catch (IOException ioException) {
            try {
                FileUtils.createNewFile(FileUtils.getCustomerDataFileName());
                setupDataStorage(new ArrayList<>(), 0L);
            } catch (Exception exception) {
                System.out.println("Failed to create customer database");
            }
        }
    }

    private void setupDataStorage(List<Customer> customerList, Long idToStart) {
        customerDataStorage.setEntities(customerList);
        customerDataStorage.setSequenceId(idToStart);
    }
}
