package repositories;

import api.data.ShopItemDataStorage;
import api.repositories.ShopItemRepository;
import model.ShopItem;
import storages.ShopItemDataStorageImpl;

public final class ShopItemRepositoryImpl extends AbstractRepositoryImpl<ShopItem>
    implements ShopItemRepository {

    private static ShopItemRepositoryImpl instance;

    private ShopItemRepositoryImpl(ShopItemDataStorage shopItemDataStorage){
        super(shopItemDataStorage);
    }

    public static ShopItemRepositoryImpl getInstance(){
        return instance == null ? instance = new ShopItemRepositoryImpl(ShopItemDataStorageImpl.getInstance())
                : instance;
    }

}
