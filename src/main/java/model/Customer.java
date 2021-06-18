package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends BaseEntity {
   private String firstName;
   private String secondName;
   private String number;
   private String email;
   private String address;



}
