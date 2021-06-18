package storages;

import api.data.ShopItemDataStorage;
import model.ShopItem;

public class ShopItemDataStorageImpl extends AbstractDataStorageImpl<ShopItem>
        implements ShopItemDataStorage {
    private ShopItemDataStorageImpl() {
    }

    private static ShopItemDataStorageImpl instance;

    public static ShopItemDataStorageImpl getInstance() {
        if (instance == null) {
            instance = new ShopItemDataStorageImpl();
        }
        return instance;
    }
}
