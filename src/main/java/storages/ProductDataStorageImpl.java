package storages;

import api.data.ProductDataStorage;
import model.Product;

public final class ProductDataStorageImpl extends AbstractDataStorageImpl<Product>
        implements ProductDataStorage {

    private ProductDataStorageImpl() {
    }

    private static ProductDataStorageImpl instance;

    public static ProductDataStorageImpl getInstance() {
      return instance == null ? instance = new ProductDataStorageImpl()
              :instance;
    }
}
