package menu.model;

import api.commands.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 @AllArgsConstructor
public class MenuItem {
    private String title;
    private Command command;

}
