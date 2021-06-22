package storages;

import api.data.OrderDataStorage;
import model.Order;

public final class OrderDataStorageImpl  extends AbstractDataStorageImpl<Order>
    implements OrderDataStorage {


    private OrderDataStorageImpl() {
    }

    private static  OrderDataStorageImpl instance;

    public static OrderDataStorageImpl getInstance() {
        return instance == null ? instance = new OrderDataStorageImpl()
                : instance;
    }
}
