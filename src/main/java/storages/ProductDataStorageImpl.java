package storages;

import api.data.ProductDataStorage;
import model.Product;

public class ProductDataStorageImpl extends AbstractDataStorageImpl<Product>
        implements ProductDataStorage {

    private ProductDataStorageImpl() {
    }

    private static ProductDataStorageImpl instance;

    public static ProductDataStorageImpl getInstance() {
        if (instance == null) {
            instance = new ProductDataStorageImpl();
        }
        return instance;
    }
}
