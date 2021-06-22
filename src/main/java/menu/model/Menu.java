package menu.model;

import commands.CommandExecutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utils.ConsoleUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
    private List<MenuItem> items;
    private Menu previousMenu;

    public void selectItem() {
        try {
            String answer = ConsoleUtils.getInputScanner().nextLine();
            int index = Integer.parseInt(answer) - 1;
            if (index < 0 || index >= items.size()) throw new Exception("There is no such item");
            CommandExecutor.getInstance().execute(items.get(index).getCommand());
        } catch (Exception exception) {
            System.out.println("\nAn error occurred: " + exception.getMessage());
        }
    }
}
