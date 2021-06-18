package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Shop extends BaseEntity {
    private String name;
    private ArrayList<ShopItem> items;
}
