package commands.product;

import api.commands.Command;
import controllers.ProductController;
import model.Product;
import model.enums.Category;
import utils.ConsoleUtils;

import java.util.EnumSet;

public final class AddProductCommand implements Command {
    private final ProductController productController;

    public AddProductCommand() {
        productController = ProductController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        Product product = new Product();
        product.setName(ConsoleUtils.getInput("name"));
        EnumSet<Category> enumSet = EnumSet.noneOf(Category.class);
        product.setCategories(enumSet);
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
                if(index== categories.length)break;
                enumSet.add(categories[index]);
            }catch (Exception exception){
                System.out.println("Incorrect index");
            }
        }
        productController.add(product);
    }
}
