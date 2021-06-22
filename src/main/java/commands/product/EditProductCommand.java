package commands.product;

import api.commands.Command;
import controllers.ProductController;
import model.Product;
import model.enums.Category;
import utils.ConsoleUtils;

import java.util.EnumSet;

public final class EditProductCommand implements Command {


    private final ProductController productController;

    public EditProductCommand() {
        productController = ProductController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        Long id = ConsoleUtils.getSelectedEntityId(productController.getAll());
        Product product = productController.get(id);
        product.setName(ConsoleUtils.getInput("name"));
        product.getCategories().clear();
        Category[] categories = Category.values();
        while(true){
            for(int i =0; i<categories.length; i++){
                System.out.println((i+1)+")"+categories[i].getInfo());
            }
            System.out.println((categories.length+1)+")exit");
            System.out.println("Input category index: ");
            String answer = ConsoleUtils.getInputScanner().nextLine();
            try {
                int index = Integer.parseInt(answer)-1;
                if(index== categories.length) break;
                product.getCategories().add(categories[index]);
            }catch (Exception exception){
                System.out.println("Incorrect index");
            }
        }
        productController.update(product);
    }
}

