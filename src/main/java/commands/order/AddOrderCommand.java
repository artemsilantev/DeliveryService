package commands.order;

import api.commands.Command;
import controllers.OrderController;
import controllers.ShopItemController;
import controllers.CustomerController;
import controllers.ProductController;
import exeptions.NoRecordException;
import model.Customer;
import model.Order;
import model.ShopItem;
import utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AddOrderCommand implements Command {
    private final OrderController orderController;
    private final ShopItemController shopItemController;
    private final CustomerController customerController;
    private final ProductController productController;
    private List<ShopItem> shopItemsToAdd;
    private Order order;

    public AddOrderCommand() {
        orderController = OrderController.getInstance();
        shopItemController = ShopItemController.getInstance();
        customerController = CustomerController.getInstance();
        productController = ProductController.getInstance();
    }

    @Override
    public void execute() throws Exception {
        System.out.println();
        shopItemsToAdd = new ArrayList<>();
        order = new Order();
        order.setItems(shopItemsToAdd);
        order.setTotalCost(0D);
        Long id = ConsoleUtils.getSelectedEntityId(customerController.getAll());
        Customer customer = new Customer(customerController.get(id));
        order.setCustomer(customer);
        while (true) {
            System.out.println();
            System.out.println(order);
            System.out.println("1)Choose product to add\n2)Delete product\n3)Confirm\n4)Back\n"
                    + "Input index:");
            String answer = ConsoleUtils.getInputScanner().nextLine();
            try {
                int index = Integer.parseInt(answer);
                switch (index) {
                    case 1:
                        addToList();
                        break;
                    case 2:
                        deleteProduct();
                        break;
                    case 3:
                        if(check()){
                            confirm();
                            orderController.add(order);
                            order = null;
                            shopItemsToAdd = null;
                            return;
                        }
                        else{
                            break;
                        }
                    case 4:
                        shopItemsToAdd = null;
                        order = null;
                        return;
                    default:
                        throw new Exception();
                }
            } catch (Exception exception) {
                System.out.println("Incorrect input");
            }

        }
    }


    private void confirm() throws NoRecordException {
        List<ShopItem> itemsToDelete = new ArrayList<>(shopItemsToAdd);
        while (itemsToDelete.size()!=0){
            ShopItem shopItemToDelete = itemsToDelete.get(0);
            ShopItem shopItemInData = shopItemController.get(shopItemToDelete.getId());
            shopItemInData.setAmount(shopItemInData.getAmount()-1);
            itemsToDelete.remove(0);
        }
    }

    private boolean check(){
        List<ShopItem> itemsToDelete = new ArrayList<>(shopItemsToAdd);
        while (itemsToDelete.size()!=0){
            ShopItem shopItemToDelete = itemsToDelete.get(0);
            int amount = Collections.frequency(itemsToDelete, shopItemToDelete);
            if(shopItemToDelete.getAmount()<amount){
                System.out.printf("\n%s does not have the required quantity of goods (%s)!\n",
                        shopItemToDelete.getShop().getName(),
                        shopItemToDelete.getProduct().getName());
                return false;

            }
            itemsToDelete.removeIf(shopItem -> shopItem.equals(shopItemToDelete));
        }
        return true;
    }

    private void deleteProduct() throws Exception {
        Long id = ConsoleUtils.getSelectedEntityId(shopItemsToAdd);
        shopItemsToAdd.remove(shopItemController.get(id));
        order.setTotalCost(order.getTotalCost() - shopItemController.get(id).getPrice());
    }

    private void addToList() throws Exception {
        Long id = ConsoleUtils.getSelectedEntityId(productController.getAll());
        List<ShopItem> shopItems = shopItemController.getByProduct(productController.get(id));
        if (shopItems.size() == 0) {
            System.out.println("The selected item is out of stock");
            return;
        }
        id = ConsoleUtils.getSelectedEntityId(shopItems);
        ShopItem shopItem = new ShopItem(shopItemController.get(id));
        int amount = Integer.parseInt(ConsoleUtils.getInput("amount"));
        if (shopItem.getAmount() < amount) {
            System.out.println("There is not enough product in stock!");
            return;
        }
        for (int i = amount; i > 0; i--) {
            order.setTotalCost(order.getTotalCost() + shopItem.getPrice());
            shopItemsToAdd.add(shopItem);
        }
    }
}
