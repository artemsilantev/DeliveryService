package commands.shopitem;

import api.commands.Command;
import controllers.ProductController;
import controllers.ShopController;
import controllers.ShopItemController;
import model.Product;
import model.Shop;
import model.ShopItem;
import model.enums.Category;
import utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public final class DisplayShopItemsByKeysCommand implements Command {
    private final ShopItemController shopItemController;
    private final ShopController shopController;
    private final ProductController productController;
    private List<ShopItem> shopItems;

    public DisplayShopItemsByKeysCommand() {
        shopItemController = ShopItemController.getInstance();
        shopController = ShopController.getInstance();
        productController = ProductController.getInstance();
    }


    @Override
    public void execute() throws Exception {
        System.out.println();
        shopItems = new ArrayList<>(shopItemController.getAll());
        while (true) {
            ConsoleUtils.displayList(shopItems);
            System.out.println("1)Sort by shop\n2)Sort by product\n3)Sort by category" +
                    "\n4)Sort by amount\n5)Sort by price\n6)Clear sorting parameters\n7)Back" +
                    "\nInput index:");
            String answer = ConsoleUtils.getInputScanner().nextLine();
            try {

                int index = Integer.parseInt(answer);
                if (index < 1 || index > 7)
                    throw new Exception();
                switch (index) {
                    case 1:
                        sortByShop();
                        break;
                    case 2:
                        sortByProduct();
                        break;
                    case 3:
                        sortByCategory();
                        break;
                    case 4:
                        sortByAmount();
                        break;
                    case 5:
                        sortByPrice();
                        break;
                    case 6:
                        shopItems = new ArrayList<>(shopItemController.getAll());
                        break;
                    case 7:
                        shopItems = null;
                        return;
                }
            } catch (Exception exception) {
                throw new Exception("Incorrect input");
            }
        }

    }

    public void sortByShop() throws Exception {
        Long id = ConsoleUtils.getSelectedEntityId(shopController.getAll());
        Shop shop = shopController.get(id);
        shopItems.removeIf(shopItem -> shopItem.getShop() != shop);
    }

    public void sortByProduct() throws Exception {
        Long id = ConsoleUtils.getSelectedEntityId(productController.getAll());
        Product product = productController.get(id);
        shopItems.removeIf(shopItem -> shopItem.getProduct() != product);
    }

    public void sortByCategory(){
        EnumSet<Category> enumSet = EnumSet.noneOf(Category.class);
        Category[] categories = Category.values();
        while (true) {
            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ")" + categories[i].getInfo());
            }
            System.out.println((categories.length + 1) + ")exit");
            System.out.println("Input category index: ");
            String answer = ConsoleUtils.getInputScanner().nextLine();
            int index = Integer.parseInt(answer) -1;
            if (index == categories.length) break;
            enumSet.add(categories[index]);
        }
        shopItems.removeIf(shopItem -> !shopItem.getProduct()
                .getCategories()
                .containsAll(enumSet));
    }

    public void sortByAmount() {
        String answer = ConsoleUtils.getInput("amount");
        int amount = Integer.parseInt(answer);
        shopItems.removeIf(shopItem -> shopItem.getAmount() < amount);
    }

    public void sortByPrice() {
        String answer = ConsoleUtils.getInput("price");
        double price = Double.parseDouble(answer);
        shopItems.removeIf(shopItem -> shopItem.getPrice() > price);
    }
}