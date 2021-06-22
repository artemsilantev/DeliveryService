package storages;

import api.data.ShopItemDataStorage;
import model.ShopItem;

public final class ShopItemDataStorageImpl extends AbstractDataStorageImpl<ShopItem>
        implements ShopItemDataStorage {
    private ShopItemDataStorageImpl() {
    }

    private static ShopItemDataStorageImpl instance;

    public static ShopItemDataStorageImpl getInstance() {
        return instance == null ? instance = new ShopItemDataStorageImpl()
                :instance;
    }
}
