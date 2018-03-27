package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class GenerationObj extends BaseObject{
    public GenerationObj(int yearFrom) {
        super("generation");
        this.yearFrom = yearFrom;
    }
    private int yearFrom;
    private int yearTo;
    private  int modelID;
    private int id;
    private int idInsert;
    public int getIdInsert() {
        return idInsert;
    }

    public void setIdInsert(int idInsert) {
        this.idInsert = idInsert;
    }


    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }


    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public int getModelID() {
        return modelID;
    }

    public GenerationObj(int id, int yearFrom, int yearTo, int modelID, int idInsert) {
        super("generation");
        this.id=id;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.modelID = modelID;
        this.idInsert = idInsert;
    }

    public GenerationObj(int yearFrom, int yearTo) {
        super("generation");
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }



    @Override
    public JsonElement toJSONObject() {

        obj1.addProperty("objectClass", objectClass);
        obj1.addProperty("id",id);
        obj1.addProperty("yearFrom", yearFrom);
        obj1.addProperty("yearTo", yearTo);
        obj1.addProperty("modelID", modelID);
        obj1.addProperty("idInsert", idInsert);


        return obj1;
    }

    @Override
    public String toString() {
        return yearFrom+" - "+yearTo;
    }
}
