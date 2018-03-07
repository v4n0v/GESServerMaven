package ru.glassexpress.objects_DB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class BaseObject {
    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public String getObjectClass() {
        return objectClass;
    }

    String objectClass;
    public BaseObject(String objectClass) {
        this.objectClass = objectClass;
        obj1 = new JsonObject();

    }
    protected JsonObject obj1;

    // серверынй метод, возвращает JSON

    abstract public JsonElement toJSONObject();
}

