package intitalizers;

import api.data.ProductDataStorage;
import api.initializers.Initializer;
import com.google.gson.reflect.TypeToken;
import model.Product;
import storages.ProductDataStorageImpl;
import utils.FileUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ProductDataInitializer implements Initializer {
    private static ProductDataInitializer instance;
    private final ProductDataStorage productDataStorage;

    private ProductDataInitializer() {

        productDataStorage = ProductDataStorageImpl.getInstance();
    }

    public static ProductDataInitializer getInstance() {
        return instance == null ? instance = new ProductDataInitializer()
                : instance;
    }

    @Override
    public void init() {
        try {
            String json = FileUtils.readInfo(FileUtils.getProductDataFileName());
            List<Product> products = JsonUtils.deserializeList(json, new TypeToken<List<Product>>(){}.getType());
            if (products == null ||products.size()==0) {
                setupDataStorage(new ArrayList<>(), 0L);
                return;
            }
            setupDataStorage(products, products.get(products.size() - 1).getId() + 1);
        } catch (IOException ioException) {
            try {
                FileUtils.createNewFile(FileUtils.getProductDataFileName());
                setupDataStorage(new ArrayList<>(), 0L);
            } catch (Exception exception) {
                System.out.println("Failed to create product database");
            }
        }
    }

    private void setupDataStorage(List<Product> productList, Long idToStart) {
        productDataStorage.setEntities(productList);
        productDataStorage.setSequenceId(idToStart);
    }
}
