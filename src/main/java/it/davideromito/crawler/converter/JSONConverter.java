package it.davideromito.crawler.converter;

import com.google.gson.Gson;

/**
 * Created by davideromito on 28/06/16.
 */
public final class JSONConverter {
    public static String toJSON(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
