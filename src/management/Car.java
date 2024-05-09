
package management;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {
    private StringProperty brand;
    private StringProperty model;
    private StringProperty id;
    private StringProperty category;
    private StringProperty price;
    private StringProperty hp;
    private StringProperty cc;
    private StringProperty emissionClass;
    private StringProperty traction;
    private StringProperty seats;

    public Car(String brand, String model, String id, String category, String price, String hp, String cc, String emissionClass, String traction, String seats) {
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.id = new SimpleStringProperty(id);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleStringProperty(price);
        this.hp = new SimpleStringProperty(hp);
        this.cc = new SimpleStringProperty(cc);
        this.emissionClass = new SimpleStringProperty(emissionClass);
        this.traction = new SimpleStringProperty(traction);
        this.seats = new SimpleStringProperty(seats);
    }
    public Car() {
        
    }
    
    public StringProperty getBrandProperty() {
        return brand;
    }
    public StringProperty getModelProperty() {
        return model;
    }
    public StringProperty getIdProperty() {
        return id;
    }
    public StringProperty getCategoryProperty() {
        return category;
    }
    public StringProperty getPriceProperty() {
        return price;
    }
    public StringProperty getHpProperty() {
        return hp;
    }
    public StringProperty getCcProperty() {
        return cc;
    }
    public StringProperty getEmissionClassProperty() {
        return emissionClass;
    }
    public StringProperty getTractionProperty() {
        return traction;
    }
    public StringProperty getSeatsProperty() {
        return seats;
    }
    
    public String getBrand() {
        return brand.get();
    }
    public String getModel() {
        return model.get();
    }
    public String getId() {
        return id.get();
    }
    public String getCategory() {
        return category.get();
    }
    public String getPrice() {
        return price.get();
    }
    public String getHp() {
        return hp.get();
    }
    public String getCc() {
        return cc.get();
    }
    public String getEmissionClass() {
        return emissionClass.get();
    }
    public String getTraction() {
        return traction.get();
    }
    public String getSeats() {
        return seats.get();
    }

    @Override
    public String toString() {
        return getBrand() + "\n" + getModel() + "\n" + getId() + "\n" + getCategory() + "\n" + getPrice() + "\n" + getHp() + "\n" + getCc() + "\n" + getEmissionClass() + "\n" + getTraction() + "\n" + getSeats();
    }
    
}
