package menu.client;

import menu.model.MenuContext;

public class MenuClient {

    private static MenuClient instance;

    private MenuClient() {
    }

    public static MenuClient getInstance() {
        return instance == null ? instance = new MenuClient()
                : instance;
    }

    public void run() {
        while (true) {
            if(MenuContext.getCurrentMenu()==null){
                System.out.println("The console menu was successfully closed");
                return;
            }
            for (int i = 0; i < MenuContext.getCurrentMenu().getItems().size(); i++) {
                System.out.println((i + 1) + ") "
                        + MenuContext.getCurrentMenu().getItems().get(i).getTitle());
            }
            System.out.println("Select an item from the menu:");
            MenuContext.getCurrentMenu().selectItem();
            System.out.println();
        }
    }
}
