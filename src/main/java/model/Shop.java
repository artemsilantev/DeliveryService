package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends BaseEntity {
    private String name;
    private String address;
    private String email;

    public Shop(Shop shop){
        this.setId(shop.getId());
        this.name = shop.name;
        this.address = shop.address;
        this.email = shop.email;
    }

    @Override
    public String toString() {
        return "Shop"+ '\n' +
                "name: " + name + '\n' +
                "address: " + address + '\n' +
                "email: " + email + '\n';
    }
}
