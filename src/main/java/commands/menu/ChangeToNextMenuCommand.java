package commands.menu;

import api.commands.Command;
import lombok.AllArgsConstructor;
import menu.model.Menu;
import menu.model.MenuContext;

@AllArgsConstructor
public final class ChangeToNextMenuCommand implements Command {

    private final Menu nextMenu;

    @Override
    public void execute() {
        Menu previousMenu = MenuContext.getCurrentMenu();
        MenuContext.setCurrentMenu(nextMenu);
        nextMenu.setPreviousMenu(previousMenu);
    }
}
