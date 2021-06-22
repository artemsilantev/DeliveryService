package services;

import api.repositories.ProductRepository;
import api.repositories.ShopItemRepository;
import api.services.ShopItemService;
import model.Product;
import model.Shop;
import model.ShopItem;
import repositories.ProductRepositoryImpl;
import repositories.ShopItemRepositoryImpl;
import utils.FileUtils;
import utils.JsonUtils;
import java.util.List;
import java.io.IOException;
import java.util.stream.Collectors;

public final class ShopItemServiceImpl extends AbstractServiceImpl<ShopItem>
        implements ShopItemService {


    private static ShopItemServiceImpl instance;

    private ShopItemServiceImpl(ShopItemRepository shopItemRepository) {
        super(shopItemRepository);
    }

    public static ShopItemServiceImpl getInstance() {
        return instance == null ? instance = new ShopItemServiceImpl(ShopItemRepositoryImpl.getInstance())
                : instance;
    }

    public List<ShopItem> getByShop(Shop shop){
        return abstractRepository.getAll().stream()
                .filter(shopItem -> shopItem.getShop().equals(shop))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShopItem> getByProduct(Product product){
        return abstractRepository.getAll().stream()
                .filter(shopItem -> shopItem.getProduct().equals(product))
                .collect(Collectors.toList());
    }

    @Override
    public ShopItem create(ShopItem entity) {
        for (ShopItem shopItem : abstractRepository.getAll()) {
            if (shopItem.getShop().equals(entity.getShop()) && shopItem.getProduct().equals(entity.getProduct())){
                entity.setId(shopItem.getId());
                return entity;
            }
        }
       return super.create(entity);
    }

    @Override
    public void saveData() throws IOException {
        String json = JsonUtils.getSerializedEntity(abstractRepository.getAll());
        FileUtils.createNewFile(FileUtils.getShopItemDataFileName());
        FileUtils.writeToFile(FileUtils.getShopItemDataFileName(), json);
    }

}
