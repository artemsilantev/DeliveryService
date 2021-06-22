package services;

import api.repositories.ProductRepository;
import api.services.ProductService;
import model.Product;
import repositories.ProductRepositoryImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;

public final class ProductServiceImpl extends AbstractServiceImpl<Product>
        implements ProductService {

    private static ProductServiceImpl instance;

    private ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

    public static ProductServiceImpl getInstance() {
        return instance == null ? instance = new ProductServiceImpl(ProductRepositoryImpl.getInstance())
                : instance;
    }

    @Override
    public Product create(Product entity) {
        for (Product product : abstractRepository.getAll()) {
            if (product.getName().equals(entity.getName())) {
                entity.setId(product.getId());
                return entity;
            }
        }
       return super.create(entity);
    }

    @Override
    public void saveData() throws IOException {
        String json = JsonUtils.getSerializedEntity(abstractRepository.getAll());
        FileUtils.createNewFile(FileUtils.getProductDataFileName());
        FileUtils.writeToFile(FileUtils.getProductDataFileName(), json);
    }

}
