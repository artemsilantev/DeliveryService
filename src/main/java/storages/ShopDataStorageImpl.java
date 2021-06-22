package storages;

import api.data.ShopDataStorage;
import model.Shop;

public final class ShopDataStorageImpl extends AbstractDataStorageImpl<Shop>
        implements ShopDataStorage {
    private ShopDataStorageImpl() {
    }

    private static ShopDataStorageImpl instance;

    public static ShopDataStorageImpl getInstance() {
        return instance == null ? instance =new ShopDataStorageImpl()
                : instance;
    }
}
