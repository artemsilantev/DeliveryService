package repositories;

import api.data.ProductDataStorage;
import api.repositories.ProductRepository;
import model.Product;
import storages.ProductDataStorageImpl;

public final class ProductRepositoryImpl extends AbstractRepositoryImpl<Product>
        implements ProductRepository {
    private static ProductRepositoryImpl instance;

    public static ProductRepositoryImpl getInstance() {
        return instance == null ? instance = new ProductRepositoryImpl(ProductDataStorageImpl.getInstance())
                : instance;
    }

    private ProductRepositoryImpl(ProductDataStorage productDataStorage) {
        super(productDataStorage);
    }
}
