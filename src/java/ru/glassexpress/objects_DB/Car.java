package ru.glassexpress.objects_DB;

public class Car extends RequestObject{
    int id;
    String mark;
    String model;
    String type;
    int carClass;

    public Car(int id, String mark, String model, String type, int carClass) {
        this.reqObj="Car";
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.type = type;
        this.carClass = carClass;
    }
    public Car(String mark, String model, String type, int carClass) {
        this.mark = mark;
        this.model = model;
        this.type = type;
        this.carClass = carClass;
    }
    @Override
    public String toString() {
        return mark+" "+model+", кузов "+type+", класс: "+carClass;
    }
}
