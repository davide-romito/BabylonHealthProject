package it.davideromito.crawler.converter;

import com.google.gson.Gson;

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
}
