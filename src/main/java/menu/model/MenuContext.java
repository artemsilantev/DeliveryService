package menu.model;

import lombok.Getter;
import lombok.Setter;


public class MenuContext {
    private MenuContext(){}

    @Setter
    @Getter
    private static Menu currentMenu;
}
