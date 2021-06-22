package repositories;

import api.data.ShopDataStorage;
import api.repositories.ShopRepository;
import model.Shop;
import storages.ShopDataStorageImpl;

public final class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop>
    implements ShopRepository {
    private static ShopRepositoryImpl instance;

    private ShopRepositoryImpl(ShopDataStorage shopDataStorage){
        super(shopDataStorage);
    }

    public static ShopRepositoryImpl getInstance(){
        return instance == null ? instance = new ShopRepositoryImpl(ShopDataStorageImpl.getInstance())
                : instance;
    }
}
