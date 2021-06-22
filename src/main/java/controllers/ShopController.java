package controllers;

import api.services.ShopService;
import exeptions.NoRecordException;
import model.Shop;
import services.ShopServiceImpl;

import java.io.IOException;

import java.util.List;

public class ShopController {

    private final ShopService shopService;

    private static ShopController instance;

    public static ShopController getInstance() {
        return instance == null ? instance = new ShopController()
                : instance;
    }

    private ShopController() {
        shopService = ShopServiceImpl.getInstance();
    }

    public Shop add(Shop shop) {
        return shopService.create(shop);
    }

    public void update(Shop shop) {
        shopService.update(shop);
    }

    public List<Shop> getAll() {
        return shopService.getAll();
    }

    public void saveData() throws IOException {
        shopService.saveData();
    }

    public void delete(Long id) throws NoRecordException {
        shopService.delete(id);
    }

    public Shop get(Long id) throws NoRecordException {
        return shopService.get(id);
    }
}
