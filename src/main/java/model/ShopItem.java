package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem extends BaseEntity{
    private Shop shop;
    private Product product;
    private Double price;
    private Integer amount;

    public ShopItem(ShopItem shopItem){
        this.shop = new Shop(shopItem.getShop());
        this.setId(shopItem.getId());
        this.product = new Product(shopItem.getProduct());
        this.price = shopItem.getPrice();
        this.amount =shopItem.getAmount();
    }

    @Override
    public String toString() {
        return "Shop item" + '\n'+
                "shop name: " + shop.getName() + '\n'+
                "product name: " + product.getName() + '\n' +
                "price: " + price + '\n'+
                "amount: " + amount + '\n';
    }
}
