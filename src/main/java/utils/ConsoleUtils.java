package utils;

import lombok.Getter;
import model.BaseEntity;

import java.util.Scanner;
import java.util.List;

public class ConsoleUtils {
    private ConsoleUtils(){}
    @Getter
    private static final Scanner inputScanner = new Scanner(System.in);

    public static String getInput(String propertyName) {
        System.out.printf("Please enter %s:\n", propertyName);
        return ConsoleUtils.getInputScanner().nextLine();
    }

    public static void displayList(List<?> list){
        for(int i =0; i<list.size();i++){
            System.out.println((i+1) +")" + list.get(i));
        }
    }

    public static Long getSelectedEntityId(List<? extends BaseEntity> list) throws Exception {
        displayList(list);
        System.out.println("Input index: ");
        int index = Integer.parseInt(inputScanner.nextLine());
        index--;
        if(index<0||index>=list.size())
            throw new Exception("Index is out of bound");
        return list.get(index).getId();
    }
}
