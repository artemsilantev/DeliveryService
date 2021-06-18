package storages;

import api.data.OrderDataStorage;
import model.Order;

public class OrderDataStorageImpl  extends AbstractDataStorageImpl<Order>
    implements OrderDataStorage {


    private OrderDataStorageImpl() {
    }

    private static  OrderDataStorageImpl instance;

    public static OrderDataStorageImpl getInstance() {
        if (instance == null) {
            instance = new OrderDataStorageImpl();
        }
        return instance;
    }
}
