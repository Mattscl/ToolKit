package com.os.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matt on 2018/5/9.
 */
public class JsonToMap
{
    public static final Gson gson = new Gson();

    public static Map jsonToMap(String jsonString)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(jsonString, map.getClass());
        return map;
    }
}
