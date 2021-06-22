package utils;

import com.google.gson.Gson;
import lombok.Getter;
import model.BaseEntity;

import java.io.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    @Getter
    private static final String customerDataFileName ="CustomersData.json";
    @Getter
    private static final String shopDataFileName ="ShopData.json";
    @Getter
    private static final String productDataFileName ="ProductData.json";
    @Getter
    private static final String shopItemDataFileName ="ShopItemData.json";
    @Getter
    private static final String orderDataFileName ="OrderData.json";


    private FileUtils() {
    }

    public static String readInfo(String pathToFile) throws IOException {
        FileReader fileReader = new FileReader(pathToFile);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()){
            builder.append(scanner.nextLine());
        }
        fileReader.close();
        return builder.toString();
    }

    public static void writeToFile(String pathToFile, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(text);
        fileWriter.close();
    }

    public static void createNewFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
    }
}
