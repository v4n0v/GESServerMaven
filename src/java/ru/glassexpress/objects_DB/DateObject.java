package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class DateObject extends BaseObject {


    private int salonId;

    public DateObject(int id) {
        super("day");
        employees = new ArrayList<>();
    }

    public DateObject(int id, Date date, String employeesJson, int idAdmin, int salonId) {
        super("day");
        employees = new ArrayList<>();
        this.id = id;
        this.date = date;
        this.employeesJson = employeesJson;
        this.idAdmin = idAdmin;
        this.salonId=salonId;
    }

    private int id;
    private Date date;
    private List<Integer> employees;

    public String getEmployeesJson() {
        return employeesJson;
    }

    public void setEmployeesJson(String employeesJson) {
        this.employeesJson = employeesJson;
    }

    private String employeesJson;
    private int idAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }


    @Override
    public JsonElement toJSONObject() {
        obj1.addProperty("objectClass", objectClass);
        obj1.addProperty("id", id);
        obj1.addProperty("date", String.valueOf(date.getTime()));
        obj1.addProperty("employeesJson", employeesJson);
        obj1.addProperty("idAdmin", idAdmin);
        obj1.addProperty("salonId", salonId);
        return obj1;
    }

    public int getSalonId() {
        return salonId;
    }
}
