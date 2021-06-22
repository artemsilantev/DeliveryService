import intitalizers.InitializerHandler;
import menu.client.MenuClient;

public class Runner {

    public static void main(String[] args){

        InitializerHandler.getInstance().start();
        MenuClient.getInstance().run();
    }
}
