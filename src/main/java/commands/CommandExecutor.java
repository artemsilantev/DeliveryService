package commands;

import api.commands.Command;

public  final class CommandExecutor {
    private static CommandExecutor instance;
    private CommandExecutor(){}

    public static CommandExecutor getInstance(){
        return instance == null ? instance = new CommandExecutor():
                instance;
    }

    public void execute(Command command){
        try {
            command.execute();
        }catch (Exception exception){
            System.out.println("\nAn error occurred: " + exception.getMessage());
        }
    }
}
