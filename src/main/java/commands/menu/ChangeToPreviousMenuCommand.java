package commands.menu;

import api.commands.Command;
import menu.model.Menu;
import menu.model.MenuContext;

public final class ChangeToPreviousMenuCommand implements Command {

    @Override
    public void execute() {
        Menu previousMenu = MenuContext.getCurrentMenu().getPreviousMenu();
        MenuContext.setCurrentMenu(previousMenu);
    }
}
