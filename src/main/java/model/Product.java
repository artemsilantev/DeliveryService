package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.Category;

import java.util.EnumSet;

@Getter
@Setter
public class Product extends BaseEntity{
    private String name;
    private EnumSet<Category> categories;
}
