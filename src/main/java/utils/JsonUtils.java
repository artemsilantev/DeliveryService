package utils;

import com.google.gson.Gson;
import lombok.Getter;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {
    @Getter
    private static Gson gson = new Gson();

    public static List deserializeList(String text, Type type){
        return gson.fromJson(text,type);
    }

    public static <E> String getSerializedEntity(E entity){
        return gson.toJson(entity);
    }
}
