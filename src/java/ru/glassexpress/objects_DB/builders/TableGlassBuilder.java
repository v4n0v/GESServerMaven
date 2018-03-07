package ru.glassexpress.objects_DB.builders;

import ru.glassexpress.objects_DB.GlassObject;
import ru.glassexpress.objects_DB.TableGlassRow;

public class TableGlassBuilder extends GlassBuilder{

    public TableGlassBuilder setInsertMethodTitle(String insertMethodTitle) {
        this.insertMethodTitle = insertMethodTitle;
        return this;
    }
    public TableGlassBuilder setInsertGlassFactoryTitle(String glassFactoryTitle) {
        this.glassFactoryTitle = glassFactoryTitle;
        return this;
    }
    public TableGlassBuilder setInsertGlassTypeTitle(String glassTypeTitle) {
        this.glassTypeTitle = glassTypeTitle;
        return this;
    }
    public TableGlassBuilder setInsertGlassOptTitle(String glassOptTitle) {
        this.glassOptTitle = glassOptTitle;
        return this;
    }
    public TableGlassBuilder setInsertCarTitle(String carTitle) {
        this.carTitle = carTitle;
        return this;
    }

    private String insertMethodTitle;
    private String glassFactoryTitle;
    private String glassTypeTitle;
    private String glassOptTitle;
    private String carTitle;

    @Override
    public GlassObject build() {
        TableGlassRow table = new TableGlassRow();
        table.setCarTitle(carTitle);
        table.setGlassFactoryTitle(glassFactoryTitle);
        table.setGlassOptTitle(glassOptTitle);
        table.setGlassTypeTitle(glassTypeTitle);
        table.setInsertMethodTitle(insertMethodTitle);
        return table;
    }
}
