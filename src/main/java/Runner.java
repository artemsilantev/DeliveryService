import intitalizers.MainInitializer;
import menu.client.MenuClient;

public class Runner {

    public static void main(String[] args){

        MainInitializer.getInstance().startInitializer();
        MenuClient.getInstance().run();
    }
}
