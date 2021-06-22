package intitalizers;

import api.initializers.Initializer;

import java.util.LinkedList;
import java.util.List;

public class InitializerHandler {
    private static InitializerHandler instance;

    private List<Initializer> initializers;

    private InitializerHandler() {
        initializers = new LinkedList<>();
        initializers.add(MenuInitializer.getInstance());
        initializers.add(CustomerDataInitializer.getInstance());
        initializers.add(ShopDataInitializer.getInstance());
        initializers.add(ProductDataInitializer.getInstance());
        initializers.add(ShopItemDataInitializer.getInstance());
        initializers.add(OrderDataInitializer.getInstance());
    }

    public static InitializerHandler getInstance() {
        return instance == null ? instance = new InitializerHandler()
                : instance;
    }

    public void start(){
        initializers.forEach(Initializer::init);
    }
}
