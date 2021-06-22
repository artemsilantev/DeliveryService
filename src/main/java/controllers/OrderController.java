package controllers;

import api.services.OrderService;
import exeptions.NoRecordException;
import model.Order;
import services.OrderServiceImpl;

import java.io.IOException;
import java.util.List;

public class OrderController {

    private final OrderService orderService;

    private static OrderController instance;

    public static OrderController getInstance() {
        return instance == null ? instance = new OrderController()
                : instance;
    }

    private OrderController() {
        orderService = OrderServiceImpl.getInstance();
    }

    public Order add(Order order) {
        return orderService.create(order);
    }

    public void update(Order order) {
        orderService.update(order);
    }

    public List<Order> getAll() {
        return orderService.getAll();
    }

    public void saveData() throws IOException {
        orderService.saveData();
    }

    public void delete(Long id) throws NoRecordException {
        orderService.delete(id);
    }

    public Order get(Long id) throws NoRecordException {
        return orderService.get(id);
    }
}
