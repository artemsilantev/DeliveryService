package intitalizers;

import api.data.OrderDataStorage;
import api.initializers.Initializer;
import com.google.gson.reflect.TypeToken;
import model.Order;
import storages.OrderDataStorageImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class OrderDataInitializer implements Initializer {

    private static OrderDataInitializer instance;
    private final OrderDataStorage orderDataStorage;

    private OrderDataInitializer() {
        orderDataStorage = OrderDataStorageImpl.getInstance();
    }

    public static OrderDataInitializer getInstance() {
        return instance == null ? instance = new OrderDataInitializer()
                : instance;
    }


    @Override
    public void init() {
        try {
            String json = FileUtils.readInfo(FileUtils.getOrderDataFileName());
            List<Order> orders = JsonUtils.deserializeList(json, new TypeToken<List<Order>>(){}.getType());
            if (orders == null || orders.size()==0) {
                setupDataStorage(new ArrayList<>(), 0L);
                return;
            }
            setupDataStorage(orders, orders.get(orders.size() - 1).getId()+1);
        } catch (IOException ioException) {
            try {
                FileUtils.createNewFile(FileUtils.getOrderDataFileName());
                setupDataStorage(new ArrayList<>(), 0L);
            } catch (Exception exception) {
                System.out.println("Failed to create order database");
            }
        }
    }

    private void setupDataStorage(List<Order> orderListList, Long idToStart) {
        orderDataStorage.setEntities(orderListList);
        orderDataStorage.setSequenceId(idToStart);
    }
}
