package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
   private String firstName;
   private String secondName;
   private String number;
   private String email;
   private String address;


   public Customer(Customer customer){
      this.setId(customer.getId());
      this.firstName = customer.firstName;
      this.secondName = customer.secondName;
      this.number = customer.number;
      this.email = customer.email;
      this.address = customer.address;
   }



   @Override
   public String toString() {
      return  "Customer"+ '\n'+
              "firstName: " + firstName + '\n' +
              "secondName: " + secondName + '\n' +
              "number: " + number + '\n' +
              "email: " + email + '\n' +
              "address: " + address+'\n';
   }
}
