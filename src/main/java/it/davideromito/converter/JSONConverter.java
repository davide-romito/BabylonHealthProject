package it.davideromito.converter;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class, to convert object in Json format
 */
public final class JSONConverter {
    private JSONConverter(){}

    /**
     * Given an Object, return the JSON format of that object
     * @param obj any type of object
     * @return Json format String
     */
    public static String toJSON(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * Given a set, return a set of string in the JSON format of that object
     * @param set any type of objects
     * @return set of Json format String
     */
    public static Set<String> toJSON(Set set){
        Set<String> stringSet = new HashSet<String>();
        Gson gson = new Gson();
        for (Object obj : set){
            stringSet.add(gson.toJson(obj));
        }
        return stringSet;
    }


    public static <T> T fromJson(String s, Class<T> clazz)
    {
        Gson gson = new Gson();
        T object = gson.fromJson(s, clazz);
        return object;
    }

}
