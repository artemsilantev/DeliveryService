package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Order extends BaseEntity{
    private Customer customer;
    private ArrayList<ShopItem> items;
}
