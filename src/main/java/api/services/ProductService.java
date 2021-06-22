package api.services;

import model.Product;
import java.io.IOException;

public interface ProductService extends AbstractService<Product> {
    void saveData() throws IOException;
}
