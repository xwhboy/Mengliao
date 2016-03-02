package com.init.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zoson on 3/26/15.
 */
public class JsonParser {
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    public JsonParser(String json){
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key){
        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getInt(String key){
        try {
            return jsonObject.getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public JSONArray getJsonArray(String name){
        try {
            return jsonArray = jsonObject.getJSONArray(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public float getFloat(String name){
        try {
            return (float)jsonObject.getDouble(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1f;
    }
    public JSONObject getJsonObject(String name){
        try {
            return jsonObject.getJSONObject(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
