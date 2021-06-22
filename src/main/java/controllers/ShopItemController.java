package controllers;

import api.services.ShopItemService;
import exeptions.NoRecordException;
import model.Product;
import model.Shop;
import model.ShopItem;
import services.ShopItemServiceImpl;

import java.io.IOException;
import java.util.List;

public class ShopItemController {

    private final ShopItemService shopItemService;

    private static ShopItemController instance;

    public static ShopItemController getInstance() {
        return instance == null ? instance = new ShopItemController()
                : instance;
    }

    private ShopItemController() {
        shopItemService = ShopItemServiceImpl.getInstance();
    }

    public ShopItem add(ShopItem shopItem) {
        return shopItemService.create(shopItem);
    }

    public void update(ShopItem shopItem) {
        shopItemService.update(shopItem);
    }

    public List<ShopItem> getAll() {
        return shopItemService.getAll();
    }

    public List<ShopItem> getByShop(Shop shop) {
        return shopItemService.getByShop(shop);
    }

    public List<ShopItem> getByProduct(Product product) {
        return shopItemService.getByProduct(product);
    }

    public void saveData() throws IOException {
        shopItemService.saveData();
    }

    public void delete(Long id) throws NoRecordException {
        shopItemService.delete(id);
    }

    public ShopItem get(Long id) throws NoRecordException {
        return shopItemService.get(id);
    }
}
