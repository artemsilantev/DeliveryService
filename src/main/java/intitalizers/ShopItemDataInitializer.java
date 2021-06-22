package intitalizers;

import api.data.ProductDataStorage;
import api.data.ShopDataStorage;
import api.data.ShopItemDataStorage;
import api.initializers.Initializer;
import com.google.gson.reflect.TypeToken;
import model.Product;
import model.Shop;
import model.ShopItem;
import storages.ProductDataStorageImpl;
import storages.ShopDataStorageImpl;
import storages.ShopItemDataStorageImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class ShopItemDataInitializer implements Initializer {
    private static ShopItemDataInitializer instance;
    private final ShopItemDataStorage shopItemDataStorage;
    private final ProductDataStorage productDataStorage;
    private final ShopDataStorage shopDataStorage;

    private ShopItemDataInitializer() {
        shopItemDataStorage = ShopItemDataStorageImpl.getInstance();
        shopDataStorage = ShopDataStorageImpl.getInstance();
        productDataStorage = ProductDataStorageImpl.getInstance();
    }

    public static ShopItemDataInitializer getInstance() {
        return instance == null ? instance = new ShopItemDataInitializer()
                : instance;
    }



    @Override
    public void init() {
        try {
            String json = FileUtils.readInfo(FileUtils.getShopItemDataFileName());
          List<ShopItem> shopItems = JsonUtils.deserializeList(json, new TypeToken<List<ShopItem>>(){}.getType());
            if (shopItems == null || shopItems.size()==0) {
                setupDataStorage(new ArrayList<>(), 0L);
                return;
            }
            List<Shop> dataShops =  shopDataStorage.getEntities();
            List<Product> dataProducts =  productDataStorage.getEntities();
            for (ShopItem shopItem : shopItems) {
                int index = dataShops.indexOf(shopItem.getShop());
                Shop shopToReplace;
                Product productToReplace;
                if (index == -1)
                    shopToReplace = shopDataStorage.create(shopItem.getShop());
                else
                    shopToReplace = dataShops.get(index);
                index = dataProducts.indexOf(shopItem.getProduct());
                if (index == -1)
                    productToReplace = productDataStorage.create(shopItem.getProduct());
                else
                    productToReplace = dataProducts.get(index);
                shopItem.setShop(shopToReplace);
                shopItem.setProduct(productToReplace);
            }
            setupDataStorage(shopItems, shopItems.get(shopItems.size() - 1).getId() + 1);
        } catch (IOException ioException) {
            try {
                FileUtils.createNewFile(FileUtils.getShopItemDataFileName());
                setupDataStorage(new ArrayList<>(), 0L);
            } catch (Exception exception) {
                System.out.println("Failed to create shop item database");
            }
        }

    }

    private void setupDataStorage(List<ShopItem> shopItemList, Long idToStart) {
        shopItemDataStorage.setEntities(shopItemList);
        shopItemDataStorage.setSequenceId(idToStart);
    }
}
