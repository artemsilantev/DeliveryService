package controllers;

import api.services.ProductService;
import exeptions.NoRecordException;
import model.Product;
import services.ProductServiceImpl;

import java.io.IOException;

import java.util.List;
public class ProductController {
    private final ProductService productService;
    private static ProductController instance;

    public static ProductController getInstance() {
        return instance == null ? instance = new ProductController()
                : instance;
    }

    private ProductController() {
        productService = ProductServiceImpl.getInstance();
    }


    public Product add(Product product) {
       return productService.create(product);
    }

    public void update(Product product) {
        productService.update(product);
    }

    public List<Product> getAll(){
        return productService.getAll();
    }

    public void saveData() throws IOException {
        productService.saveData();
    }

    public void delete(Long id) throws NoRecordException {
        productService.delete(id);
    }

    public Product get(Long id) throws NoRecordException {
        return productService.get(id);
    }
}
