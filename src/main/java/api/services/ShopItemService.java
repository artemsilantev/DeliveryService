package api.services;

import model.Product;
import model.Shop;
import model.ShopItem;
import java.io.IOException;
import java.util.List;

public interface ShopItemService extends AbstractService<ShopItem> {
    void saveData() throws IOException;
    List<ShopItem> getByShop(Shop shop);
    List<ShopItem> getByProduct(Product product);
}
