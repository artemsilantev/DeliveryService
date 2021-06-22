package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enums.Category;

import java.util.EnumSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    private String name;
    private EnumSet<Category> categories;

    public Product(Product product){
        this.setId(product.getId());
        this.name = product.name;
        this.categories = product.categories.clone();
    }

    private String getCategoryString(){
        StringBuilder stringBuilder = new StringBuilder();
        categories.forEach(category -> stringBuilder.append(category.getInfo()).append(", "));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Product" + '\n'+
                "name: " + name + '\n' +
                "categories: " + getCategoryString() +'\n';
    }
}
