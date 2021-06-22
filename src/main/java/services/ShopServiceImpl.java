package services;

import api.repositories.ShopRepository;
import api.services.ShopService;
import model.Shop;
import repositories.ShopRepositoryImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;

public final class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {

    private static ShopServiceImpl instance;

    private ShopServiceImpl(ShopRepository shopRepository){

        super(shopRepository);
    }

    public static ShopServiceImpl getInstance(){
        return instance == null ? instance = new ShopServiceImpl(ShopRepositoryImpl.getInstance())
                : instance;
    }

    @Override
    public Shop create(Shop entity) {
        for(Shop shop :abstractRepository.getAll()){
            if(shop.getEmail().equals(entity.getEmail())){
                entity.setId(shop.getId());
                return entity;
            }
        }
       return super.create(entity);
    }

    @Override
    public void saveData() throws IOException {
        String json = JsonUtils.getSerializedEntity(abstractRepository.getAll());
        FileUtils.createNewFile(FileUtils.getShopDataFileName());
        FileUtils.writeToFile(FileUtils.getShopDataFileName(),json);
    }
}
