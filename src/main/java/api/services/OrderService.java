package api.services;

import model.Order;
import java.io.IOException;

public interface OrderService extends AbstractService<Order>{
    void saveData() throws IOException;
}
