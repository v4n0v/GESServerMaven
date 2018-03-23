package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

public class ServiceObject extends BaseObject {


   private int id;

    public ServiceObject(int id, String title, float price) {
        super("service");
        this.id = id;
        this.title = title;
        this.price = price;
    }

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private  float price;

    @Override
    public JsonElement toJSONObject() {
        obj1.addProperty("objClass", objectClass);
        obj1.addProperty("id", id);
        obj1.addProperty("title", title);
        obj1.addProperty("price", price);
        return obj1;
    }
}
