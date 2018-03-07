package ru.glassexpress.objects_DB.builders;

import ru.glassexpress.objects_DB.InsertClass;

public class InsertClassBuilder {

    private  int id;
    private float insertFront;
    private float insertRear;
    private  float insertSide;
    private  float toneFront;

    public InsertClassBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public InsertClassBuilder setInsertFront(float insertFront) {
        this.insertFront = insertFront;
        return this;
    }

    public InsertClassBuilder setInsertRear(float insertRear) {
        this.insertRear = insertRear;
        return this;
    }

    public InsertClassBuilder setInsertSide(float insertSide) {
        this.insertSide = insertSide;
        return this;
    }

    public InsertClassBuilder setToneFront(float toneFront) {
        this.toneFront = toneFront;
        return this;
    }

    public InsertClass build(){
        InsertClass insertClass =new InsertClass();
        insertClass.setId(id);
        insertClass.setInsertFront(insertFront);
        insertClass.setInsertRear(insertRear);
        insertClass.setInsertSide(insertSide);
        insertClass.setToneFront(toneFront);

        return insertClass;
    }

}
