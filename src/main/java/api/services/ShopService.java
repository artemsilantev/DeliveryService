package api.services;

import model.Shop;
import java.io.IOException;

public interface ShopService extends AbstractService<Shop> {
    void saveData() throws IOException;
}
