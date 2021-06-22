package intitalizers;

import api.data.CustomerDataStorage;
import api.data.ShopDataStorage;
import api.initializers.Initializer;
import com.google.gson.reflect.TypeToken;
import model.Customer;
import model.Product;
import model.Shop;
import storages.CustomerDataStorageImpl;
import storages.ShopDataStorageImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ShopDataInitializer implements Initializer {
    private static  ShopDataInitializer instance;
    private final ShopDataStorage shopDataStorage;

    private ShopDataInitializer() {
        shopDataStorage = ShopDataStorageImpl.getInstance();
    }

    public static ShopDataInitializer getInstance() {
        return instance == null ? instance = new ShopDataInitializer()
                : instance;
    }


    @Override
    public void init() {
        try {
            String json = FileUtils.readInfo(FileUtils.getShopDataFileName());
            List<Shop> shops = JsonUtils.deserializeList(json, new TypeToken<List<Shop>>(){}.getType());
            if (shops== null || shops.size()==0) {
                setupDataStorage(new ArrayList<>(), 0l);
                return;
            }
            setupDataStorage(shops, shops.get(shops.size() - 1).getId()+1);
        } catch (IOException ioException) {
            try {
                FileUtils.createNewFile(FileUtils.getShopDataFileName());
                setupDataStorage(new ArrayList<>(), 0l);
            } catch (Exception exception) {
                System.out.println("Failed to create shop database");
            }
        }
    }

    private void setupDataStorage(List<Shop> shopsList, Long idToStart) {
        shopDataStorage.setEntities(shopsList);
        shopDataStorage.setSequenceId(idToStart);
    }
}
