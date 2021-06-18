package model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopItem extends BaseEntity{
    private Product product;
    private Double price;
    private Shop shop;
}
