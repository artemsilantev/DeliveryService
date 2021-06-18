package storages;

import api.data.ShopDataStorage;
import model.Shop;

public class ShopDataStorageImpl extends AbstractDataStorageImpl<Shop>
        implements ShopDataStorage {
    private ShopDataStorageImpl() {
    }

    private static ShopDataStorageImpl instance;

    public static ShopDataStorageImpl getInstance() {
        if (instance == null) {
            instance = new ShopDataStorageImpl();
        }
        return instance;
    }
}
