package repositories;

import api.data.OrderDataStorage;
import api.repositories.OrderRepository;
import model.Order;
import storages.OrderDataStorageImpl;

public final class OrderRepositoryImpl extends AbstractRepositoryImpl<Order>
    implements OrderRepository {
    private static OrderRepositoryImpl instance;

    public static OrderRepositoryImpl getInstance(){
        return instance == null ? instance = new OrderRepositoryImpl(OrderDataStorageImpl.getInstance())
                : instance;
    }

    private OrderRepositoryImpl(OrderDataStorage orderDataStorage){
        super(orderDataStorage);
    }
}
