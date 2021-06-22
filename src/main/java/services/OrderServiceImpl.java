package services;

import api.repositories.OrderRepository;
import api.repositories.ShopRepository;
import api.services.OrderService;
import model.Order;
import model.Shop;
import repositories.OrderRepositoryImpl;
import repositories.ShopRepositoryImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;

public final class OrderServiceImpl extends AbstractServiceImpl<Order>
    implements OrderService {
    private static OrderServiceImpl instance;

    private OrderServiceImpl(OrderRepository orderRepository){
        super(orderRepository);
    }

    public static OrderServiceImpl getInstance(){
        return instance == null ? instance = new OrderServiceImpl(OrderRepositoryImpl.getInstance())
                : instance;
    }

    @Override
    public Order create(Order entity) {
        for(Order order : abstractRepository.getAll()){
            if(order.equals(entity)){
                entity.setId(order.getId());
                return entity;
            }
        }
        return super.create(entity);
    }

    @Override
    public void saveData() throws IOException {
        String json = JsonUtils.getSerializedEntity(abstractRepository.getAll());
        FileUtils.createNewFile(FileUtils.getOrderDataFileName());
        FileUtils.writeToFile(FileUtils.getOrderDataFileName(),json);
    }
}
