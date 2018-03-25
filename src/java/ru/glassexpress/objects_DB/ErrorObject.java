package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

public class ErrorObject extends BaseObject{
    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public ErrorObject(String message) {
        super("error");
        this.message=message;
    }

    @Override
    public JsonElement toJSONObject() {
        obj1.addProperty("objClass", objectClass);
        obj1.addProperty("message", message);
        return obj1;
    }

    public String getMessage() {
        return message;
    }
}
