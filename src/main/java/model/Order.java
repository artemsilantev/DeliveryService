package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity{
    private Customer customer;
    private List<ShopItem> items;
    private Double totalCost;

    private String getShopItemString(){
        StringBuilder stringBuilder = new StringBuilder();
        items.forEach(shopItem -> stringBuilder.append(shopItem.getProduct().getName())
                .append('\t').append(shopItem.getShop().getName())
                .append('\t').append(shopItem.getPrice()).append('\n'));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Order info: " + '\n' +
                "customer info:\n" +
                "name: "+ customer.getFirstName()+'\n'+
                "second name: "+ customer.getSecondName()+'\n'+
                "telephone number: "+ customer.getNumber()+'\n'+
                "address: "+ customer.getAddress()+'\n'+
                "order items info:\n" + getShopItemString() +
                "total cost: " + totalCost+'\n';
    }
}
