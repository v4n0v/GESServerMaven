package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

public class OkObject extends BaseObject{
    public OkObject() {
        super("ok");
    }

    @Override
    public JsonElement toJSONObject() {
        obj1.addProperty("objectClass", objectClass);
        return obj1;
    }
}
