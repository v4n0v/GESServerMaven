package ru.glassexpress.objects_DB;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableGlassRow extends GlassObject{
    public String getInsertMethodTitle() {
        return insertMethodTitle;
    }

    public void setInsertMethodTitle(String insertMethodTitle) {
        this.insertMethodTitle = insertMethodTitle;
    }

    public String getGlassFactoryTitle() {
        return glassFactoryTitle;
    }

    public void setGlassFactoryTitle(String glassFactoryTitle) {
        this.glassFactoryTitle = glassFactoryTitle;
    }

    public String getGlassTypeTitle() {
        return glassTypeTitle;
    }

    public void setGlassTypeTitle(String glassTypeTitle) {
        this.glassTypeTitle = glassTypeTitle;
    }

    public String getGlassOptTitle() {
        return glassOptTitle;
    }

    public void setGlassOptTitle(String glassOptTitle) {
        this.glassOptTitle = glassOptTitle;
    }


    public String getCarTitle() {
        return carTitle;
    }

    private String insertMethodTitle;
    private String glassFactoryTitle;
    private String glassTypeTitle;
    private String glassOptTitle;
    private String carTitle;


    public SimpleObjectProperty<Integer> getIdProperty() {
        return new SimpleObjectProperty<Integer>(this.getId());
    }

    public SimpleObjectProperty<Integer> getGlassTypeProperty() {
        return new SimpleObjectProperty<Integer>(this.getGlassTypeId());
    }
    public SimpleObjectProperty<Integer> getGlassOptProperty() {
        return new SimpleObjectProperty<Integer>(this.getGlassOptionId());
    }
    public SimpleObjectProperty<Float> getPriceProperty() {
        return new SimpleObjectProperty<Float>(this.getPrice());
    }
    public SimpleObjectProperty<Float> getPriceInProperty() {
        return new SimpleObjectProperty<Float>(this.getPriceIn());
    }
    public SimpleObjectProperty<Integer> getAlertProperty() {
        return new SimpleObjectProperty<Integer>(this.getAlert());
    }
    public StringProperty getDescProperty() {
        return new SimpleStringProperty(carTitle+"/ "+this.getDescription());
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

}
