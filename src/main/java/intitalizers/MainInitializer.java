package intitalizers;

import api.initializers.Initializer;
import menu.MenuInitializer;

import java.util.LinkedList;
import java.util.List;

public class MainInitializer {
    private static MainInitializer instance;

    private List<Initializer> initializers;

    private MainInitializer() {
        initializers = new LinkedList<>();
        initializers.add(MenuInitializer.getInstance());
        initializers.add(CustomerDataInitializer.getInstance());
        initializers.add(ShopDataInitializer.getInstance());
        initializers.add(ProductDataInitializer.getInstance());
        initializers.add(ShopItemDataInitializer.getInstance());
        initializers.add(OrderDataInitializer.getInstance());
    }

    public static MainInitializer getInstance() {
        return instance == null ? instance = new MainInitializer()
                : instance;
    }

    public void startInitializer(){
        initializers.forEach(Initializer::init);
    }
}
